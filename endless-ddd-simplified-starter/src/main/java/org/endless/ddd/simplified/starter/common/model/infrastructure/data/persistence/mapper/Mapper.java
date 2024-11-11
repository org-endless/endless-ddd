package org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.endless.ddd.simplified.starter.common.config.log.annotation.Log;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.mapper.*;
import org.endless.ddd.simplified.starter.common.exception.infrastructure.data.persistence.page.PageFindException;
import org.endless.ddd.simplified.starter.common.model.domain.entity.Entity;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.persistence.page.PageCallback;
import org.endless.ddd.simplified.starter.common.model.infrastructure.data.record.DataRecord;
import org.endless.ddd.simplified.starter.common.utils.string.StringTools;
import org.endless.ddd.simplified.starter.common.utils.time.TimeStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Mapper
 * <p>DDD-Mybatis-plus Mapper类型模版
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/11/03 13:48
 *
 * @author Deng Haozhi
 * @see BaseMapper
 * @since 2.0.0
 */
public interface Mapper<R extends DataRecord<? extends Entity>> extends BaseMapper<R> {

    Logger log = LoggerFactory.getLogger(Mapper.class);

    Set<Class<?>> MAPPER_MODIFY_SUPPORTED_TYPES = new HashSet<>(Arrays.asList(
            Integer.class, int.class, Long.class, long.class, Double.class, double.class,
            Float.class, float.class, Boolean.class, boolean.class, String.class,
            byte[].class, Byte[].class, Date.class, java.sql.Date.class,
            Timestamp.class, BigDecimal.class
    ));

    Set<String> MAPPER_MODIFY_EXCLUDED_FIELDS = new HashSet<>(Arrays.asList(
            "createAt", "modifyAt"
    ));
    Optional<R> findByIdForUpdate(String id);
    /**
     * 根据ID查询记录
     *
     * @param id 主键ID
     * @return {@link Optional }<{@link R }>
     */
    @Log(message = "数据库根据ID查询记录", value = "' ID：' + #id", level = "TRACE")
    default Optional<R> findById(String id) {
        Optional.ofNullable(id)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new MapperFindException("数据库根据ID查询ID不能为空"));
        try {
            return Optional.ofNullable(this.selectById(id))
                    .filter(record -> record.getIsRemoved() == null || !record.getIsRemoved());
        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new MapperFindException("数据库根据ID查询记录失败，ID: " + id, e);
        }
    }
    @Log(message = "数据库根据ID查询记录", value = "' ID：' + #id", level = "TRACE")
    default Optional<R> findByIdNew(String id) {
        try {
            QueryWrapper<R> queryWrapper = new QueryWrapper<>();
            queryWrapper
                    .eq(StringTools.toSnake(getRecordIdName()), id)
                    .eq("is_removed", false);
            return Optional.ofNullable(this.selectOne(queryWrapper));
        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new MapperFindException("数据库根据ID查询记录失败，ID: " + id, e);
        }
    }

    @Log(message = "数据库根据ID列表查询记录", value = "' ID：' + #ids.toString()", level = "TRACE")
    default List<R> findByIds(List<String> ids) {
        Optional.ofNullable(ids)
                .filter(l -> !l.isEmpty())
                .orElseThrow(() -> new MapperFindException("数据库根据ID列表ID列表不能为空"));
        try {

            // 查询并过滤掉已标记删除的记录
            return Optional.ofNullable(this.selectByIds(ids))
                    .orElse(new ArrayList<>())
                    .stream()
                    .filter(record -> record.getIsRemoved() == null || !record.getIsRemoved())
                    .collect(Collectors.toList());
        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new MapperFindException("数据库根据ID列表查询记录失败", e);
        }
    }

    @Log(message = "数据库根据ID列表查询记录", value = "' ID：' + #ids.toString()", level = "TRACE")
    default List<R> findByIdsNew(List<String> ids) {
        try {
            QueryWrapper<R> queryWrapper = new QueryWrapper<>();
            queryWrapper
                    .in(StringTools.toSnake(getRecordIdName()), ids)
                    .eq("is_removed", false);
            return this.selectList(queryWrapper);
        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new MapperFindException("数据库根据ID列表查询记录失败", e);
        }
    }

    @Log(message = "数据库根据条件查询记录", value = "#queryWrapper", level = "TRACE")
    default Optional<R> findByWrapper(QueryWrapper<R> queryWrapper) {
        try {
            queryWrapper.eq("is_removed", false);
            return Optional.ofNullable(selectOne(queryWrapper));
        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new MapperFindException("数据库根据ID列表查询记录失败", e);
        }
    }

    /**
     * 数据库记录分页查询，使用查询方法
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @param callback 回调函数
     * @return {@link PageInfo }<{@link R }>
     */
    @Log(message = "数据库分页查询记录", value = "' 开始页：' + #pageNum + ', 每页记录数：' + #pageSize", level = "TRACE")
    default PageInfo<R> findPages(int pageNum, int pageSize, PageCallback<R> callback) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            // 执行回调并获取结果
            List<R> result = callback.execute();
            return new PageInfo<>(result);

        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new PageFindException("数据库分页查询失败", e);
        }
    }

    /**
     * 数据库记录分页查询，使用查询条件
     *
     * @param pageNum      页码
     * @param pageSize     每页记录数
     * @param queryWrapper 查询条件
     * @return {@link PageInfo }<{@link R }>
     */
    @Log(message = "数据库分页查询记录", value = "' 开始页：' + #pageNum + ', 每页记录数：' + #pageSize", level = "TRACE")
    default PageInfo<R> findPages(int pageNum, int pageSize, QueryWrapper<R> queryWrapper) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            // 过滤掉已删除的记录
            queryWrapper.eq("is_removed", false);
            List<R> results = this.selectList(queryWrapper);

            return PageInfo.of(results);
        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new PageFindException("分页查询失败", e);
        }
    }

    /**
     * 写入数据库记录
     *
     * @param record 数据库实体
     */
    @Log(message = "数据库写入记录", value = "#record", level = "TRACE")
    default void save(R record) {
        String id = null;
        try {
            Optional.ofNullable(record)
                    .orElseThrow(() -> new MapperModifyException("要存入的数据库记录不能为空"));
            id = record.idValue();
            if (this.insert(record) == 0) {
                throw new MapperSaveException("数据库记录存入失败，ID: " + id);
            }
        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new MapperSaveException("数据库记录存入失败，ID: " + id, e);
        }
    }

    /**
     * 新增或修改数据库记录
     *
     * @param record 数据库实体
     */
    @Log(message = "数据库写入或更新记录", value = "#record", level = "TRACE")
    default void upsert(R record) {
        String id = null;
        try {
            Optional.ofNullable(record)
                    .orElseThrow(() -> new MapperModifyException("要写入或更新的数据库的记录不能为空"));
            id = record.idValue();
            if (!this.insertOrUpdate(record)) {
                throw new MapperUpsertException("数据库写入或更新记录失败，ID: " + id);
            }
        } catch (MapperException e) {
            throw e;
        } catch (Exception e) {
            throw new MapperUpsertException("数据库写入或更新记录失败，ID: " + id, e);
        }
    }

    /**
     * 删除数据库记录
     *
     * @param record 数据库记录
     */
    @Log(message = "数据库删除记录", value = "#record", level = "TRACE")
    default void remove(R record) {
        String id = null;
        try {
            Optional.ofNullable(record)
                    .orElseThrow(() -> new MapperRemoveFailedException("要删除的数据库记录不能为空"));
            id = record.idValue();

            if (record.getIsRemoved() == null || !record.getIsRemoved()) {
                throw new MapperRemoveFailedException("数据库删除记录时删除标志 isRemoved 必须为 true，ID: " + id);
            }
            modify(record);

        } catch (MapperException e) {
            throw new MapperRemoveFailedException("数据库更新删除标志失败，ID: " + id + "，" + e.getMessage(), e);
        } catch (Exception e) {
            throw new MapperRemoveException("数据库删除记录异常，ID: " + id, e);
        }
    }

    /**
     * 批量删除数据库记录, 使用事务，每批次最多 不能超过 10 条
     *
     * @param records 数据库记录列表
     */
    @Log(message = "数据库批量删除记录", value = "#record", level = "TRACE")
    default void remove(List<R> records) {
        if (records == null || records.isEmpty()) {
            throw new MapperRemoveFailedException("要删除的数据库记录列表不能为空");
        }

        if (records.size() > 10) {
            throw new MapperRemoveFailedException("每批次删除的数据库记录数量不能超过 10，当前数量：" + records.size());
        }

        int count = 0;  // 计数器
        for (R record : records) {
            String id = null;
            try {
                count++;  // 记录当前是第几条
                Long start = TimeStamp.now();
                id = record.idValue();
                remove(record);  // 调用单条删除方法


                log.trace("数据库删除记录成功，第 {} 条记录，ID: {}，耗时：{} 毫秒", count, id, TimeStamp.between(start, TimeStamp.now()));
            } catch (MapperException e) {
                throw new MapperRemoveFailedException("数据库更新删除标志失败，ID: " + id + "，第 " + count + " 条记录", e);
            } catch (Exception e) {
                throw new MapperRemoveException("数据库删除记录异常，ID: " + id + "，第 " + count + " 条记录", e);
            }
        }
    }

    /**
     * 修改数据库记录
     *
     * @param record 要更新的数据库记录
     */
    @Log(message = "数据库更新记录", value = "#records", level = "TRACE")
    default void modify(R record) {
        String id = null;
        int retryCount = 0;
        final int MAX_RETRY_COUNT = 3;

        while (retryCount < MAX_RETRY_COUNT) {
            try {
                Optional.ofNullable(record)
                        .orElseThrow(() -> new MapperModifyFailedException("要更新的数据库记录不能为空"));
                id = record.idValue();
                String idName = record.idName();

                R existingRecord = this.selectById(id);
                // 检查记录是否存在
                if (existingRecord == null) {
                    throw new MapperModifyFailedException("要更新的数据库记录不存在，ID: " + id);
                }
                // 检查更新时间（乐观锁）字段
                if (existingRecord.getModifyAt() == null) {
                    throw new MapperModifyFailedException("数据库记录不存在更新时间，无法进行乐观锁检查，ID: " + id);
                }
                // 检查删除标志字段
                Boolean isRemoved = existingRecord.getIsRemoved();
                if (isRemoved == null) {
                    throw new MapperModifyFailedException("数据库记录状态异常，请检查删除标志，ID: " + id);
                } else if (isRemoved) {
                    throw new MapperModifyFailedException("数据库记录被标记为已删除，ID: " + id);
                }

                UpdateWrapper<R> wrapper = new UpdateWrapper<>();
                wrapper.eq(StringTools.toSnake(record.idName()), id);
                wrapper.eq("modify_at", existingRecord.getModifyAt());
                boolean hasUpdates = false;
                // 遍历所有字段，设置非空且不同的字段
                for (Field field : record.getClass().getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        Object newValue = field.get(record);
                        Object existingValue = field.get(existingRecord);
                        String fieldName = field.getName();
                        Class<?> fieldType = field.getType();
                        if (newValue != null && !Objects.equals(newValue, existingValue)
                                && MAPPER_MODIFY_SUPPORTED_TYPES.contains(fieldType)
                                && !MAPPER_MODIFY_EXCLUDED_FIELDS.contains(fieldName)
                                && !fieldName.equals(idName)) {
                            log.trace("字段 {} 值变更: {} -> {}", fieldName, existingValue, newValue);
                            // 只在有新值且不同的情况下设置更新
                            wrapper.set(StringTools.toSnake(fieldName), newValue);
                            hasUpdates = true; // 标记为有更新
                        }
                    } catch (IllegalAccessException e) {
                        throw new MapperModifyFailedException("数据库更新字段时反射访问出错", e);
                    } catch (Exception e) {
                        throw new MapperModifyFailedException("数据库更新字段时获取 getter 方法出错", e);
                    }
                }
                // 执行更新操作
                if (hasUpdates && this.update(record, wrapper) == 0) {
                    retryCount++;
                    log.warn("数据库更新记录失败，重试第 {} 次，ID: {}", retryCount, id);
                    if (retryCount == MAX_RETRY_COUNT) {
                        throw new MapperModifyFailedException("数据库更新记录失败，已达到最大重试次数，ID: " + id);
                    }
                } else {
                    break; // 成功更新则跳出循环
                }
            } catch (MapperException e) {
                throw e;
            } catch (Exception e) {
                throw new MapperModifyException("数据库更新记录异常，ID: " + id, e);
            }
        }
    }
    default String getRecordIdName() {
        Class<?> proxyClass = this.getClass();
        for (Type interfaceType : proxyClass.getGenericInterfaces()) {
            if (interfaceType instanceof ParameterizedType paramType) {
                Type[] typeArguments = paramType.getActualTypeArguments();
                if (typeArguments.length > 0 && typeArguments[0] instanceof Class<?> entityClass) {
                    Field idField = Arrays.stream(entityClass.getDeclaredFields())
                            .filter(field -> field.isAnnotationPresent(TableId.class))
                            .findFirst()
                            .orElseThrow(() ->
                                    new MapperException("未找到标注了 @TableId 注解的 ID 字段，类: " + entityClass.getName()));
                    return idField.getName();
                }
            }
        }
        throw new MapperException("未找到泛型接口的类型信息。");
    }
    default String findIdFieldInType(Type[] interfaces) {
        for (Type type : interfaces) {
            if (type instanceof ParameterizedType paramType) {
                Type[] typeArguments = paramType.getActualTypeArguments();
                if (typeArguments.length > 0 && typeArguments[0] instanceof Class<?> entityClass) {
                    for (Field field : entityClass.getDeclaredFields()) {
                        if (field.isAnnotationPresent(TableId.class)) {
                            return field.getName();
                        }
                    }
                    throw new MapperException("未找到标注了 @TableId 注解的 ID 字段，类: " + entityClass.getName());
                }
            }
        }
        return null; // 未找到合适的泛型参数
    }
}
