DROP TABLE IF EXISTS generator_${domain.getName()?lower_case};

CREATE TABLE generator_${domain.getName()?lower_case}
(
    ${domain.getName()?uncap_first}_id        TEXT PRIMARY KEY,  -- ${domain.getName()}ID
    name                    TEXT    NOT NULL,  -- ${domain.getName()}名称
    description             TEXT    NOT NULL,  -- ${domain.getName()}描述
    version                 TEXT    NOT NULL,  -- ${domain.getName()}版本号
    author                  TEXT    NOT NULL,  -- ${domain.getName()}作者
    create_user_id          TEXT    NOT NULL,  -- 创建者ID
    modify_user_id          TEXT    NOT NULL,  -- 修改者ID
    is_removed              INTEGER NOT NULL,  -- 是否已删除（布尔值用0/1表示）
    create_at               INTEGER NOT NULL,  -- 创建时间
    modify_at               INTEGER NOT NULL,  -- 修改时间
    remove_at               INTEGER DEFAULT 0, -- 删除时间
    UNIQUE (${domain.getName()?uncap_first}_id, remove_at)
); 