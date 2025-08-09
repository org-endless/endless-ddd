DROP TABLE IF EXISTS generator_context;
CREATE TABLE generator_context (
    context_id     VARCHAR(255) NOT NULL PRIMARY KEY, -- '限界上下文ID'
    service_id     VARCHAR(255) NOT NULL,             -- '服务ID'
    name           VARCHAR(255) NOT NULL,             -- '限界上下文名称'
    description    VARCHAR(255) NOT NULL,             -- '限界上下文描述'
    version        VARCHAR(255) NOT NULL,             -- '限界上下文版本'
    author         VARCHAR(255) NOT NULL,             -- '限界上下文作者'
    root_path      VARCHAR(255) NOT NULL,             -- '限界上下文根路径'
    base_package   VARCHAR(255) NOT NULL,             -- '限界上下文基础包名'
    type           VARCHAR(255) NOT NULL,             -- '限界上下文类型'
    create_at      BIGINT       NOT NULL,             -- '限界上下文创建时间'
    modify_at      BIGINT       NOT NULL,             -- '限界上下文修改时间'
    create_user_id VARCHAR(255) NOT NULL,             -- '创建者ID'
    modify_user_id VARCHAR(255) NOT NULL,             -- '修改者ID'
    is_removed     BOOLEAN      NOT NULL,             -- '是否已删除'
    remove_at      BIGINT       NULL DEFAULT 0        -- '删除时间'
) -- '限界上下文表';
