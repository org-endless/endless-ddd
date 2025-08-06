DROP TABLE IF EXISTS generator_service;
CREATE TABLE generator_service
(
    service_id          VARCHAR(255) NOT NULL PRIMARY KEY, -- '服务ID'
    project_id          VARCHAR(255) NOT NULL,             -- '项目ID'
    service_artifact_id VARCHAR(255) NOT NULL,             -- '服务构件ID'
    group_id            VARCHAR(255) NOT NULL,             -- '服务组织ID'
    name                VARCHAR(255) NOT NULL,             -- '服务名称'
    description         VARCHAR(255) NOT NULL,             -- '服务描述'
    author              VARCHAR(255) NOT NULL,             -- '服务作者'
    root_path           VARCHAR(255) NOT NULL,             -- '服务根路径'
    base_package        VARCHAR(255) NOT NULL,             -- '服务基础包名'
    class_name_prefix   VARCHAR(255) NOT NULL,             -- '服务类名前缀'
    type                VARCHAR(255) NOT NULL,             -- '服务类型'
    port                INT          NOT NULL,             -- '服务端口'
    create_at           BIGINT       NOT NULL,             -- '服务创建时间'
    modify_at           BIGINT       NOT NULL,             -- '服务修改时间'
    create_user_id      VARCHAR(255) NOT NULL,             -- '创建者ID'
    modify_user_id      VARCHAR(255) NOT NULL,             -- '修改者ID'
    is_removed          BOOLEAN      NOT NULL,             -- '是否已删除'
    remove_at           BIGINT       NULL DEFAULT 0,       -- '删除时间'
    UNIQUE (project_id, remove_at),
    UNIQUE (service_artifact_id, remove_at)
);
