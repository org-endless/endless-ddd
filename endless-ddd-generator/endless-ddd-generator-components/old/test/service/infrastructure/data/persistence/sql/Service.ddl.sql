DROP TABLE IF EXISTS generator_service;
CREATE TABLE generator_service (
    service_id VARCHAR(255) NOT NULL PRIMARY KEY COMMENT '服务ID',
    project_id VARCHAR(255) NOT NULL COMMENT '项目ID',
    service_artifact_id VARCHAR(255) NOT NULL COMMENT '服务构件ID',
    group_id VARCHAR(255) NOT NULL COMMENT '服务组织ID',
    name VARCHAR(255) NOT NULL COMMENT '服务名称',
    description VARCHAR(255) NOT NULL COMMENT '服务描述',
    version VARCHAR(255) NOT NULL COMMENT '服务版本号',
    author VARCHAR(255) NOT NULL COMMENT '服务作者',
    root_path VARCHAR(255) NOT NULL COMMENT '服务根路径',
    base_package VARCHAR(255) NOT NULL COMMENT '服务基础包名',
    class_name_prefix VARCHAR(255) NOT NULL COMMENT '服务类名前缀',
    type VARCHAR(255) NOT NULL COMMENT '服务类型',
    port INT NOT NULL COMMENT '服务端口',
    create_at BIGINT NOT NULL COMMENT '服务创建时间',
    modify_at BIGINT NOT NULL COMMENT '服务更新时间',
    create_user_id VARCHAR(255) NOT NULL COMMENT '创建者ID',
    modify_user_id VARCHAR(255) NOT NULL COMMENT '修改者ID',
    is_removed BOOLEAN NOT NULL COMMENT '是否已删除',
    create_at BIGINT NOT NULL COMMENT '创建时间',
    modify_at BIGINT NOT NULL COMMENT '修改时间',
    remove_at BIGINT NULL DEFAULT 0 COMMENT '删除时间'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT '服务表';