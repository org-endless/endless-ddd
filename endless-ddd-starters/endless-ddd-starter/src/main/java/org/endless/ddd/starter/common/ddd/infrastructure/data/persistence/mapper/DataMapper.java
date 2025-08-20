package org.endless.ddd.starter.common.ddd.infrastructure.data.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.endless.ddd.starter.common.config.data.persistence.mybatis.bulk.MapperBulkOperations;
import org.endless.ddd.starter.common.ddd.domain.entity.Entity;
import org.endless.ddd.starter.common.ddd.infrastructure.data.persistence.page.PageCallback;
import org.endless.ddd.starter.common.ddd.infrastructure.data.record.DataRecord;
import org.endless.ddd.starter.common.exception.ddd.infrastructure.data.persistence.mapper.*;
import org.endless.ddd.starter.common.utils.error.message.database.DatabaseErrorParser;
import org.endless.ddd.starter.common.utils.model.string.StringTools;
import org.endless.ddd.starter.common.utils.model.time.TimestampTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * DataMapper
 * <p>Mybatis-plus 通用 Mapper 接口
 * <p>
 * create 2024/09/03 09:35
 * <p>
 * update 2024/11/03 13:48
 *
 * @see BaseMapper
 * @since 1.0.0
 */
public interface DataMapper<R extends DataRecord<? extends Entity>> extends BaseMapper<R> {

    Logger log = LoggerFactory.getLogger(DataMapper.class);

    Optional<R> findByIdForUpdate(String id);

    /**
     * 数据库根据ID查询记录
     *
     * @param id 主键ID
     * @return {@link Optional }<{@link R }>
     */
    default Optional<R> findById(String id) {
        Optional.ofNullable(id)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new MybatisFindException("ID不能为空"));
        try {
            return Optional.ofNullable(this.selectById(id))
                    .filter(dataRecord -> Boolean.FALSE.equals(dataRecord.getIsRemoved()));
        } catch (Exception e) {
            throw new MybatisFindException("根据ID查询记录失败，ID: " + id + ", " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 数据库根据ID列表查询记录
     *
     * @param ids ID列表
     * @return {@link List }<{@link R }>
     */
    default List<R> findByIds(List<String> ids) {
        Optional.ofNullable(ids)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisFindException("ID列表不能为空"));
        try {
            return this.selectByIds(ids).stream()
                    .filter(dataRecord -> Boolean.FALSE.equals(dataRecord.getIsRemoved()))
                    .toList();
        } catch (Exception e) {
            throw new MybatisFindException("根据ID列表查询记录失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 数据库根据条件查询第一条记录
     *
     * @param queryWrapper 查询条件
     * @return {@link Optional }<{@link R }>
     */
    default Optional<R> findFirstByWrapper(QueryWrapper<R> queryWrapper) {
        Optional.ofNullable(queryWrapper)
                .orElseThrow(() -> new MybatisFindException("查询条件不能为空"));
        try {
            queryWrapper.eq("is_removed", false);
            return Optional.ofNullable(this.selectOne(queryWrapper, false));
        } catch (Exception e) {
            throw new MybatisFindException("根据条件查询第一条记录失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 数据库根据条件查询记录
     *
     * @param queryWrapper 查询条件
     * @return {@link Optional }<{@link R }>
     */
    default List<R> findAllByWrapper(QueryWrapper<R> queryWrapper) {
        Optional.ofNullable(queryWrapper)
                .orElseThrow(() -> new MybatisFindException("查询条件不能为空"));
        try {
            queryWrapper.eq("is_removed", false);
            return selectList(queryWrapper);
        } catch (Exception e) {
            throw new MybatisFindException("根据条件查询记录失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 数据库查询所有记录
     *
     * @return {@link Optional }<{@link R }>
     */
    default List<R> findAll() {
        try {
            return selectList(new QueryWrapper<R>().eq("is_removed", false));
        } catch (Exception e) {
            throw new MybatisFindException("数据库查询所有记录失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 数据库根据ID查询记录是否存在
     *
     * @param id 主键ID
     * @return {@link Boolean }
     */
    default Boolean existsById(String id) {
        Optional.ofNullable(id)
                .filter(StringUtils::hasText)
                .orElseThrow(() -> new MybatisFindException("ID不能为空"));
        try {
            return Optional.ofNullable(this.selectById(id))
                    .filter(dataRecord -> Boolean.FALSE.equals(dataRecord.getIsRemoved()))
                    .isPresent();
        } catch (Exception e) {
            throw new MybatisFindException("根据ID查询记录是否存在失败，ID: " + id + ", " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 数据库根据ID列表查询记录是否存在
     *
     * @param ids ID列表
     * @return {@link Boolean }
     */
    default Boolean existsByIds(List<String> ids) {
        Optional.ofNullable(ids)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisFindException("ID列表不能为空"));
        try {
            List<R> records = this.selectByIds(ids).stream()
                    .filter(dataRecord -> Boolean.FALSE.equals(dataRecord.getIsRemoved()))
                    .toList();
            if (records.size() > ids.size()) {
                throw new MybatisFindException("数据库存在重复数据");
            }
            return records.size() == ids.size();
        } catch (MybatisFindException e) {
            throw e;
        } catch (Exception e) {
            throw new MybatisFindException("根据ID列表查询记录是否存在失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 根据条件查询记录是否存在
     *
     * @param queryWrapper 查询条件
     * @return {@link Boolean }
     */
    default Boolean existsByWrapper(QueryWrapper<R> queryWrapper) {
        Optional.ofNullable(queryWrapper)
                .orElseThrow(() -> new MybatisFindException("查询条件不能为空"));
        try {
            queryWrapper.eq("is_removed", false);
            return countByWrapper(queryWrapper).orElse(0L) > 0;
        } catch (MybatisFindException e) {
            throw e;
        } catch (Exception e) {
            throw new MybatisFindException("根据条件查询记录是否存在失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
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
    default PageInfo<R> findPageByMethod(PageCallback<R> callback, Integer pageNum, Integer pageSize) {
        Optional.of(pageNum).filter(f -> f >= 0)
                .orElseThrow(() -> new MybatisFindException("开始页码不能小于0"));
        Optional.of(pageSize).filter(f -> f > 0)
                .orElseThrow(() -> new MybatisFindException("每页记录数必须大于0"));
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<R> result = callback.execute();
            return PageInfo.of(result);
        } catch (MybatisFindException e) {
            throw e;
        } catch (Exception e) {
            throw new MybatisFindException("分页查询失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 数据库记录分页查询，使用查询条件
     * 记录总数
     *
     * @param pageNum      页码
     * @param pageSize     每页记录数
     * @param queryWrapper 查询条件
     * @return {@link PageInfo }<{@link R }>
     */
    default PageInfo<R> findPageByWrapper(QueryWrapper<R> queryWrapper, Integer pageNum, Integer pageSize) {
        return findPageByWrapper(queryWrapper, pageNum, pageSize, true);
    }

    /**
     * 数据库记录分页查询，使用查询条件
     *
     * @param queryWrapper 查询条件
     * @param pageNum      页码
     * @param pageSize     每页记录数
     * @param count        是否统计总记录数
     * @return {@link PageInfo }<{@link R }>
     */
    default PageInfo<R> findPageByWrapper(QueryWrapper<R> queryWrapper, Integer pageNum, Integer pageSize, Boolean count) {
        Optional.of(pageNum).filter(f -> f >= 0)
                .orElseThrow(() -> new MybatisFindException("开始页码不能小于0"));
        Optional.of(pageSize).filter(f -> f > 0)
                .orElseThrow(() -> new MybatisFindException("每页记录数必须大于0"));
        Optional.ofNullable(queryWrapper)
                .orElseThrow(() -> new MybatisFindException("查询条件不能为空"));
        try {
            PageHelper.startPage(pageNum, pageSize, count);
            queryWrapper.eq("is_removed", false);
            List<R> results = this.selectList(queryWrapper);
            return PageInfo.of(results);
        } catch (Exception e) {
            throw new MybatisFindException("根据查询条件分页查询失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 根据条件查询记录数量
     *
     * @param queryWrapper 查询条件
     * @return {@link Long }
     */
    default Optional<Long> countByWrapper(QueryWrapper<R> queryWrapper) {
        Optional.ofNullable(queryWrapper)
                .orElseThrow(() -> new MybatisFindException("查询条件不能为空"));
        try {
            queryWrapper.eq("is_removed", false);
            return Optional.of(selectCount(queryWrapper));
        } catch (Exception e) {
            throw new MybatisFindException("根据条件查询记录数失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 保存数据库记录
     *
     * @param dataRecord 数据库实体
     */
    default void save(R dataRecord) {
        Optional.ofNullable(dataRecord)
                .orElseThrow(() -> new MybatisSaveFailedException("要保存的数据库记录不能为空"));
        try {
            if (this.insert(dataRecord) == 0) {
                throw new MybatisSaveFailedException("数据库保存记录失败");
            }
        } catch (MybatisSaveFailedException e) {
            throw e;
        } catch (Exception e) {
            throw new MybatisSaveFailedException("数据库保存记录异常: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 批量保存数据库记录
     *
     * @param records 数据库实体列表
     */
    default void save(List<R> records) {
        Optional.ofNullable(records)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisSaveFailedException("要保存的数据库记录列表不能为空"))
                .forEach(this::save);
    }

    /**
     * 批量保存数据库记录，单次提交
     *
     * @param records     数据库记录列表
     * @param mapperClass 数据库记录映射器类
     * @param operations  批量操作接口
     */
    default void save(List<R> records, Class<? extends DataMapper<R>> mapperClass, MapperBulkOperations<R> operations) {
        Optional.ofNullable(records)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisSaveFailedException("要保存的数据库记录列表不能为空"));
        operations.execute(records, mapperClass, DataMapper::save);
    }

    /**
     * 新增或修改数据库记录
     *
     * @param dataRecord 数据库实体
     */
    default void upsert(R dataRecord) {
        Optional.ofNullable(dataRecord)
                .orElseThrow(() -> new MybatisUpsertFailedException("要新增或修改的数据库的记录不能为空"));
        String id = dataRecord.idValue()
                .orElseThrow(() -> new MybatisUpsertFailedException("要新增或修改的数据库记录 ID 不能为空"));
        try {
            Optional<R> existingRecord = findById(id);
            if (existingRecord.isPresent()) {
                modify(dataRecord, existingRecord.get());
            } else {
                save(dataRecord);
            }
        } catch (Exception e) {
            throw new MybatisUpsertFailedException("数据库新增或修改记录失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 批量新增或修改数据库记录
     *
     * @param records 数据库实体列表
     */
    default void upsert(List<R> records) {
        Optional.ofNullable(records)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisUpsertFailedException("要新增或修改的数据库记录列表不能为空"))
                .forEach(this::upsert);
    }

    /**
     * 批量新增或修改数据库记录，单次提交
     *
     * @param records     数据库记录列表
     * @param mapperClass 数据库记录映射器类
     * @param operations  批量操作接口
     */
    default void upsert(List<R> records, Class<? extends DataMapper<R>> mapperClass, MapperBulkOperations<R> operations) {
        Optional.ofNullable(records)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisUpsertFailedException("要新增或修改的数据库记录列表不能为空"));
        operations.execute(records, mapperClass, DataMapper::upsert);
    }

    /**
     * 删除数据库记录
     *
     * @param dataRecord 数据库记录
     */
    default void remove(R dataRecord) {
        Optional.ofNullable(dataRecord)
                .orElseThrow(() -> new MybatisRemoveFailedException("要删除的数据库记录不能为空"));
        String id = dataRecord.idValue()
                .orElseThrow(() -> new MybatisRemoveFailedException("要删除的数据库记录 ID 不能为空"));
        Optional.ofNullable(dataRecord.getIsRemoved())
                .filter(isRemoved -> isRemoved)
                .orElseThrow(() -> new MybatisRemoveFailedException("要删除的数据库记录未被标记为删除，ID: " + id));
        try {
            modify(dataRecord);
        } catch (Exception e) {
            throw new MybatisRemoveFailedException("数据库删除记录失败: " + DatabaseErrorParser.parse(e.getMessage()), e);
        }
    }

    /**
     * 批量删除数据库记录
     *
     * @param records 数据库记录列表
     */
    default void remove(List<R> records) {
        Optional.ofNullable(records)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisRemoveFailedException("要删除的数据库记录列表不能为空"))
                .forEach(this::remove);
    }

    /**
     * 批量删除修改数据库记录，单次提交
     *
     * @param records     数据库记录列表
     * @param mapperClass 数据库记录映射器类
     * @param operations  批量操作接口
     */
    default void remove(List<R> records, Class<? extends DataMapper<R>> mapperClass, MapperBulkOperations<R> operations) {
        Optional.ofNullable(records)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisRemoveFailedException("要删除的数据库记录列表不能为空"));
        operations.execute(records, mapperClass, DataMapper::remove);
    }

    /**
     * 修改数据库记录
     *
     * @param dataRecord 要更新的数据库记录
     */
    default void modify(R dataRecord) {
        Optional.ofNullable(dataRecord)
                .orElseThrow(() -> new MybatisModifyFailedException("要修改的数据库记录不能为空"));
        String id = dataRecord.idValue()
                .orElseThrow(() -> new MybatisModifyFailedException("要修改的数据库记录 ID 不能为空"));
        R existingRecord = findById(id)
                .orElseThrow(() -> new MybatisModifyFailedException("要修改的数据库记录不存在，ID: " + id));
        modify(dataRecord, existingRecord);
    }

    /**
     * 批量修改数据库记录
     *
     * @param records 数据库记录列表
     */
    default void modify(List<R> records) {
        Optional.ofNullable(records)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisModifyFailedException("要修改的数据库列表不能为空"))
                .forEach(this::modify);
    }

    /**
     * 批量修改数据库记录，单次提交
     *
     * @param records     数据库记录列表
     * @param mapperClass 数据库记录映射器类
     * @param operations  批量操作接口
     */
    default void modify(List<R> records, Class<? extends DataMapper<R>> mapperClass, MapperBulkOperations<R> operations) {
        Optional.ofNullable(records)
                .filter(l -> !CollectionUtils.isEmpty(l))
                .orElseThrow(() -> new MybatisModifyFailedException("要修改的数据库列表不能为空"));
        operations.execute(records, mapperClass, DataMapper::modify);
    }

    default void modify(R dataRecord, R existingRecord) {
        String id = dataRecord.idValue()
                .orElseThrow(() -> new MybatisModifyFailedException("要修改的数据库记录 ID 不能为空"));
        int retryCount = 0;
        final int MAX_RETRY_COUNT = 3;
        while (retryCount < MAX_RETRY_COUNT) {
            Long now = TimestampTools.now();
            try {
                String idName = dataRecord.idName();
                // 检查更新时间（乐观锁）字段
                if (existingRecord.getModifyAt() == null) {
                    throw new MybatisModifyFailedException("数据库记录不存在修改时间，无法进行乐观锁检查，ID: " + id);
                }
                // 检查删除标志字段
                Optional.ofNullable(existingRecord.getIsRemoved())
                        .filter(isRemoved -> !isRemoved)
                        .orElseThrow(() -> new MybatisModifyFailedException("数据库记录已删除，无法再次删除，ID: " + id));
                UpdateWrapper<R> wrapper = new UpdateWrapper<>();
                wrapper.eq(StringTools.convertToSnake(dataRecord.idName()), id);
                wrapper.eq("modify_at", existingRecord.getModifyAt());
                if (dataRecord.getIsRemoved() != null && dataRecord.getIsRemoved()) {
                    Optional.ofNullable(existingRecord.getRemoveAt())
                            .filter(removeAt -> removeAt == 0L)
                            .orElseThrow(() -> new MybatisModifyFailedException("数据库记录已删除，无法再次删除，ID: " + id));
                    wrapper.set("remove_at", now);
                }
                boolean hasUpdates = false;
                // 遍历所有字段，设置非空且不同的字段
                for (Field field : dataRecord.getClass().getDeclaredFields()) {
                    try {
                        Object newValue = field.get(dataRecord);
                        Object existingValue = field.get(existingRecord);
                        String fieldName = field.getName();
                        Class<?> fieldType = field.getType();
                        if (!Objects.equals(newValue, existingValue)
                                && (mapperModifySupportedTypes().contains(fieldType) || fieldType.isEnum())
                                && !mapperModifyExcludedFields().contains(fieldName)
                                && !fieldName.equals(idName)) {
                            log.trace("字段 {} 值变更: {} -> {}", fieldName, existingValue, newValue);
                            wrapper.set(StringTools.convertToSnake(fieldName), newValue);
                            hasUpdates = true;
                        }
                    } catch (IllegalAccessException e) {
                        throw new MybatisModifyFailedException("数据库修改字段时反射访问出错", e);
                    } catch (Exception e) {
                        throw new MybatisModifyFailedException("数据库修改字段时获取 getter 方法出错", e);
                    }
                }
                wrapper.set("modify_at", now);
                // 执行更新操作
                if (hasUpdates && this.update(wrapper) == 0) {
                    retryCount++;
                    log.warn("数据库修改记录失败，重试第 {} 次，ID: {}", retryCount, id);
                    if (retryCount == MAX_RETRY_COUNT) {
                        throw new MybatisModifyFailedException("数据库修改记录失败，已达到最大重试次数，ID: " + id);
                    }
                } else {
                    break;
                }
            } catch (MybatisFailedException e) {
                throw e;
            } catch (Exception e) {
                throw new MybatisModifyFailedException("数据库修改记录失败，ID: " + id + ", " + DatabaseErrorParser.parse(e.getMessage()), e);
            }
        }
    }

    default Set<Class<?>> mapperModifySupportedTypes() {
        return new HashSet<>(Arrays.asList(
                Integer.class, int.class, Long.class, long.class, Double.class, double.class,
                Float.class, float.class, Boolean.class, boolean.class, String.class,
                byte[].class, Byte[].class, Date.class, java.sql.Date.class,
                java.sql.Timestamp.class, BigDecimal.class
        ));
    }

    default Set<String> mapperModifyExcludedFields() {
        return new HashSet<>(Arrays.asList(
                "createAt", "modifyAt", "removeAt"
        ));
    }
}
