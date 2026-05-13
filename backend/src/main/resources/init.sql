-- 北京千面科技有限公司官网数据库初始化脚本

CREATE DATABASE IF NOT EXISTS hippo_website DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE hippo_website;

-- 公司信息表
CREATE TABLE IF NOT EXISTS company_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) DEFAULT NULL COMMENT '公司名称',
    description TEXT COMMENT '公司描述',
    vision VARCHAR(500) DEFAULT NULL COMMENT '公司愿景',
    employee_count INT DEFAULT 0 COMMENT '员工数量',
    project_count INT DEFAULT 0 COMMENT '项目数量',
    client_count INT DEFAULT 0 COMMENT '客户数量',
    years_experience INT DEFAULT 0 COMMENT '行业经验',
    image_url VARCHAR(500) DEFAULT NULL COMMENT '图片URL',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司信息';

-- 业务服务表
CREATE TABLE IF NOT EXISTS service (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL COMMENT '服务标题',
    description TEXT COMMENT '服务描述',
    icon VARCHAR(100) DEFAULT NULL COMMENT '图标',
    sort_order INT DEFAULT 0 COMMENT '排序',
    features TEXT COMMENT '特点(JSON数组)',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='业务服务';

-- 解决方案表
CREATE TABLE IF NOT EXISTS solution (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL COMMENT '方案标题',
    description TEXT COMMENT '方案描述',
    category VARCHAR(100) DEFAULT NULL COMMENT '分类',
    image_url VARCHAR(500) DEFAULT NULL COMMENT '图片URL',
    features TEXT COMMENT '特点(JSON数组)',
    sort_order INT DEFAULT 0 COMMENT '排序',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='解决方案';

-- 合作伙伴表
CREATE TABLE IF NOT EXISTS partner (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL COMMENT '合作伙伴名称',
    logo_url VARCHAR(500) DEFAULT NULL COMMENT 'Logo URL',
    website VARCHAR(500) DEFAULT NULL COMMENT '网站',
    sort_order INT DEFAULT 0 COMMENT '排序',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='合作伙伴';

-- 联系消息表
CREATE TABLE IF NOT EXISTS contact_message (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '姓名',
    email VARCHAR(100) NOT NULL COMMENT '邮箱',
    phone VARCHAR(50) DEFAULT NULL COMMENT '电话',
    message TEXT NOT NULL COMMENT '留言内容',
    status VARCHAR(20) DEFAULT 'PENDING' COMMENT '状态(PENDING/PROCESSED/DONE)',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='联系消息';

-- 插入初始数据
INSERT INTO company_info (name, description, vision, employee_count, project_count, client_count, years_experience) VALUES 
('北京千面科技有限公司', '北京千面科技有限公司是一家专注于互联网应用服务的科技企业，致力于为客户提供优质的互联网解决方案。', '成为客户最信赖的互联网服务合作伙伴', 50, 200, 100, 10);

INSERT INTO service (title, description, icon, sort_order, features) VALUES 
('软件开发', '提供定制化的软件开发服务，包括Web应用、移动应用、企业管理系统等', 'code', 1, '["Web开发","移动应用","系统集成"]'),
('UI/UX设计', '专业的用户体验设计，打造优质的产品界面', 'palette', 2, '["界面设计","用户体验","品牌设计"]'),
('云服务', '提供云计算部署、运维和咨询服务', 'cloud', 3, '["云部署","运维服务","咨询服务"]'),
('数据分析', '深度数据分析和可视化服务', 'analytics', 4, '["数据挖掘","可视化","报告输出"]'),
('营销推广', '全渠道营销推广解决方案', 'campaign', 5, '["SEO优化","SEM投放","社交营销"]'),
('技术支持', '7x24小时技术支持和维护服务', 'support', 6, '["远程支持","现场服务","定期维护"]');

INSERT INTO solution (title, description, category, sort_order, features) VALUES 
('企业官网解决方案', '一站式企业官网建设方案，从设计到上线全程服务', 'enterprise', 1, '["响应式设计","SEO优化","CMS管理"]'),
('电商解决方案', '全渠道电商平台建设，支持多终端', 'ecommerce', 2, '["商品管理","订单管理","支付集成"]'),
('企业内部系统', 'OA、CRM、ERP等企业内部管理系统', 'internal', 3, ['权限管理','工作流','数据分析']'),
('小程序解决方案', '微信小程序全行业解决方案', 'miniapp', 4, '["模板开发","定制开发","运营工具"]'),
('APP解决方案', 'iOS/Android原生和混合开发', 'app', 5, '["原生开发","混合开发","发布上架"]'),
('行业解决方案', '针对特定行业的定制解决方案', 'industry', 6, '["教育","医疗","金融"]');

INSERT INTO partner (name, logo_url, website, sort_order) VALUES 
('阿里巴巴', 'https://img.alicdn.com/tfs/TB1_ZX7mBTHMKJjy0FiXXXc2epXa_-!!-62195229.png', 'https://www.alibaba.com', 1),
('腾讯', 'https://img1.taqqc1m/brand_logo/tencent.png', 'https://www.tencent.com', 2),
('华为', 'https://www.huawei.com/logo.png', 'https://www.huawei.com', 3),
('百度', 'https://www.baidu.com/img/bd_logo1.png', 'https://www.baidu.com', 4),
('京东', 'https://img1.360buyimg.com/popshop/jdsc_20210831.png', 'https://www.jd.com', 5);