# EndlessDDD Starter

> 🚀 一个简洁清晰的领域驱动设计（DDD）启动器模块，提供完整的 DDD 项目骨架和基础设施。

---

## 📋 项目概述

EndlessDDD Starter 是一个基于 Spring Boot 3.3.5 和 Java 21 的 DDD 项目启动器，提供了完整的领域驱动设计架构实现。该模块包含了所有必要的配置、工具类和基础设施，让您可以快速开始 DDD 项目开发。

### 🎯 设计目标

- **🚀 快速启动**: 零配置启动 DDD 项目
- **🎯 架构清晰**: 严格遵循 DDD 分层架构
- **🔧 开箱即用**: 内置完整的工具链和配置
- **📈 可扩展**: 支持自定义配置和扩展
- **🔄 持续演进**: 基于最新技术栈，持续更新

### 🌟 核心优势

- **完整的 DDD 支持**: 聚合根、实体、值对象、仓储模式
- **现代化技术栈**: Java 21、Spring Boot 3.3.5、CQRS 架构
- **丰富的工具类**: 加密、ID 生成、数据处理等工具
- **完善的异常处理**: 统一的异常处理机制
- **灵活的配置**: 支持多环境配置和自定义配置

## 🎯 核心特性

### ✅ DDD 架构支持
- **分层架构**: 清晰的应用层、领域层、基础设施层分离
- **聚合设计**: 完整的聚合根、实体、值对象支持
- **仓储模式**: 统一的仓储接口和实现
- **领域服务**: 支持领域服务的设计模式
- **CQRS 支持**: 命令查询职责分离架构

### ✅ 现代化技术栈
- **Java 21**: 使用最新的 LTS 版本
- **Spring Boot 3.3.5**: 基于最新稳定版本
- **Spring Security**: 安全认证和授权
- **Spring Data**: 数据访问层支持
- **Spring Cache**: 缓存支持

### ✅ 开箱即用
- **自动配置**: 零配置启动
- **工具类库**: 丰富的工具类和注解
- **异常处理**: 统一的异常处理机制
- **日志系统**: 完整的日志配置
- **监控支持**: 健康检查和指标监控

### ✅ 安全集成
- **JWT 认证**: 基于 JWT 的身份认证
- **权限控制**: 细粒度的权限管理
- **加密工具**: 数据加密和解密
- **安全配置**: 完整的安全配置

### ✅ 数据支持
- **多数据源**: 支持多种数据库
- **缓存支持**: Redis、Caffeine 等缓存
- **事务管理**: 声明式事务支持
- **连接池**: 数据库连接池配置

## 🏗️ 项目结构

```
endless-ddd-starter/
├── src/main/java/org/endless/ddd/starter/
│   ├── common/                    # 公共模块
│   │   ├── config/               # 配置类
│   │   │   ├── data/            # 数据配置
│   │   │   │   ├── cache/       # 缓存配置
│   │   │   │   └── persistence/ # 持久化配置
│   │   │   ├── endless/         # Endless 配置
│   │   │   │   ├── constant/    # 常量定义
│   │   │   │   └── properties/  # 属性配置
│   │   │   ├── log/             # 日志配置
│   │   │   │   ├── annotation/  # 日志注解
│   │   │   │   ├── aspect/      # 日志切面
│   │   │   │   └── type/        # 日志类型
│   │   │   ├── minio/           # MinIO 配置
│   │   │   ├── rest/            # REST 配置
│   │   │   └── thread/          # 线程配置
│   │   ├── exception/           # 异常处理
│   │   │   ├── common/          # 通用异常
│   │   │   ├── config/          # 配置异常
│   │   │   ├── identity/        # 身份异常
│   │   │   ├── model/           # 模型异常
│   │   │   └── security/        # 安全异常
│   │   ├── handler/             # 处理器
│   │   │   ├── exception/       # 异常处理器
│   │   │   └── result/          # 结果处理器
│   │   ├── model/               # 模型定义
│   │   │   ├── application/     # 应用层模型
│   │   │   ├── common/          # 通用模型
│   │   │   ├── domain/          # 领域层模型
│   │   │   ├── facade/          # 外观层模型
│   │   │   ├── infrastructure/  # 基础设施层模型
│   │   │   └── sidecar/         # 边车层模型
│   │   └── utils/               # 工具类
│   │       ├── crypto/          # 加密工具
│   │       ├── data/            # 数据处理工具
│   │       ├── id/              # ID 生成工具
│   │       ├── model/           # 模型工具
│   │       └── security/        # 安全工具
│   └── resources/               # 资源文件
│       └── META-INF/           # 元数据
│           └── spring/          # Spring 配置
└── pom.xml                     # Maven 配置
```

## 🚀 快速开始

### 1. 添加依赖

在您的 `pom.xml` 中添加依赖：

```xml
<dependency>
    <groupId>org.endless</groupId>
    <artifactId>endless-ddd-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### 2. 启用自动配置

在您的启动类上添加注解：

```java
@SpringBootApplication
@EnableEndlessDDD
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}
```

### 3. 配置属性

在 `application.yml` 中添加配置：

```yaml
endless:
  ddd:
    enabled: true
    auto-configuration: true
    logging:
      enabled: true
      level: INFO
```

## 🔧 核心功能

### 📊 数据配置

#### 缓存配置
```java
@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        // 缓存配置
        return new ConcurrentMapCacheManager();
    }
}
```

#### 持久化配置
```java
@Configuration
@EnableJpaRepositories(basePackages = "your.package.repository")
public class PersistenceConfig {
    @Bean
    public DataSource dataSource() {
        // 数据源配置
        return DataSourceBuilder.create().build();
    }
}
```

### 🔐 安全配置

#### 身份认证
```java
@Component
public class IdentityService {
    public UserDetails loadUserByUsername(String username) {
        // 身份认证逻辑
        return userDetails;
    }
}
```

#### 权限控制
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
            .requestMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
        );
        return http.build();
    }
}
```

### 📝 日志系统

#### 日志注解
```java
@LogExecution
public class YourService {
    public void businessMethod() {
        // 自动记录执行日志
    }
}
```

#### 日志切面
```java
@Aspect
@Component
public class LogAspect {
    @Around("@annotation(LogExecution)")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        // 日志切面处理
        return joinPoint.proceed();
    }
}
```

### 🔄 REST 配置

#### 客户端配置
```java
@Configuration
public class RestClientConfig {
    @Bean
    public RestTemplate restTemplate() {
        // REST 客户端配置
        return new RestTemplate();
    }
}
```

#### 异常处理
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException ex) {
        // 全局异常处理
        return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
    }
}
```

## 🛠️ 使用示例

### 1. 创建聚合根

```java
@Aggregate
public class Order {
    private OrderId id;
    private CustomerId customerId;
    private List<OrderItem> items;
    private OrderStatus status;
    
    // 构造函数
    public Order(OrderId id, CustomerId customerId) {
        this.id = id;
        this.customerId = customerId;
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }
    
    // 领域逻辑
    public void addItem(ProductId productId, int quantity) {
        OrderItem item = new OrderItem(productId, quantity);
        items.add(item);
    }
    
    public void confirm() {
        if (items.isEmpty()) {
            throw new DomainException("订单不能为空");
        }
        this.status = OrderStatus.CONFIRMED;
    }
    
    public void cancel() {
        this.status = OrderStatus.CANCELLED;
    }
}
```

### 2. 创建实体

```java
@Entity
public class OrderItem {
    private ProductId productId;
    private int quantity;
    private BigDecimal price;
    
    public OrderItem(ProductId productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    
    public BigDecimal getTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
```

### 3. 创建值对象

```java
@ValueObject
public class OrderId {
    private final String value;
    
    public OrderId(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("订单ID不能为空");
        }
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OrderId orderId = (OrderId) obj;
        return Objects.equals(value, orderId.value);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
```

### 4. 创建仓储接口

```java
public interface OrderRepository extends Repository<Order, OrderId> {
    List<Order> findByCustomerId(CustomerId customerId);
    Optional<Order> findById(OrderId id);
    List<Order> findByStatus(OrderStatus status);
    void save(Order order);
    void delete(OrderId id);
}
```

### 5. 创建应用服务

```java
@Service
@Transactional
public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    
    public OrderApplicationService(OrderRepository orderRepository, 
                                 ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }
    
    public OrderId createOrder(CreateOrderCommand command) {
        // 验证命令
        validateCommand(command);
        
        // 创建聚合根
        OrderId orderId = OrderId.generate();
        Order order = new Order(orderId, command.getCustomerId());
        
        // 添加订单项
        for (OrderItemCommand itemCommand : command.getItems()) {
            Product product = productService.findById(itemCommand.getProductId());
            order.addItem(product.getId(), itemCommand.getQuantity());
        }
        
        // 保存聚合根
        orderRepository.save(order);
        
        return orderId;
    }
    
    public void confirmOrder(OrderId orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new OrderNotFoundException("订单不存在"));
        
        order.confirm();
        orderRepository.save(order);
    }
    
    private void validateCommand(CreateOrderCommand command) {
        if (command.getCustomerId() == null) {
            throw new IllegalArgumentException("客户ID不能为空");
        }
        if (command.getItems().isEmpty()) {
            throw new IllegalArgumentException("订单项不能为空");
        }
    }
}
```

### 6. 创建查询服务

```java
@Service
public class OrderQueryService {
    private final OrderRepository orderRepository;
    
    public OrderQueryService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public OrderDTO getOrder(OrderId orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new OrderNotFoundException("订单不存在"));
        
        return OrderDTO.fromOrder(order);
    }
    
    public List<OrderDTO> getOrdersByCustomer(CustomerId customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream()
            .map(OrderDTO::fromOrder)
            .collect(Collectors.toList());
    }
    
    public List<OrderDTO> getOrdersByStatus(OrderStatus status) {
        List<Order> orders = orderRepository.findByStatus(status);
        return orders.stream()
            .map(OrderDTO::fromOrder)
            .collect(Collectors.toList());
    }
}
```

### 7. 创建控制器

```java
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderApplicationService orderApplicationService;
    private final OrderQueryService orderQueryService;
    
    public OrderController(OrderApplicationService orderApplicationService,
                          OrderQueryService orderQueryService) {
        this.orderApplicationService = orderApplicationService;
        this.orderQueryService = orderQueryService;
    }
    
    @PostMapping
    public ResponseEntity<OrderId> createOrder(@RequestBody CreateOrderCommand command) {
        OrderId orderId = orderApplicationService.createOrder(command);
        return ResponseEntity.ok(orderId);
    }
    
    @PostMapping("/{orderId}/confirm")
    public ResponseEntity<Void> confirmOrder(@PathVariable String orderId) {
        orderApplicationService.confirmOrder(new OrderId(orderId));
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable String orderId) {
        OrderDTO order = orderQueryService.getOrder(new OrderId(orderId));
        return ResponseEntity.ok(order);
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomer(@PathVariable String customerId) {
        List<OrderDTO> orders = orderQueryService.getOrdersByCustomer(new CustomerId(customerId));
        return ResponseEntity.ok(orders);
    }
}
```

## ⚙️ 配置选项

### 基础配置

```yaml
endless:
  ddd:
    # 启用 DDD 功能
    enabled: true
    
    # 自动配置
    auto-configuration: true
    
    # 日志配置
    logging:
      enabled: true
      level: INFO
      pattern: "[%d{yyyy-MM-dd HH:mm:ss.SSS}][%-5p][%T][%c.%M:%L]%msg%xEx%n"
    
    # 缓存配置
    cache:
      enabled: true
      type: redis
      ttl: 3600
    
    # 安全配置
    security:
      enabled: true
      jwt:
        secret: your-secret-key
        expiration: 86400
```

### 数据源配置

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database
    username: your_username
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
        format_sql: true
```

### 缓存配置

```yaml
spring:
  cache:
    type: redis
    redis:
      host: localhost
      port: 6379
      password: your_password
      database: 0
      timeout: 2000ms
```

### 安全配置

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://your-auth-server.com
          jwk-set-uri: https://your-auth-server.com/.well-known/jwks.json
```

## 🔍 故障排除

### 常见问题

#### 1. 自动配置不生效
```yaml
# 检查配置
endless:
  ddd:
    enabled: true
    auto-configuration: true
```

#### 2. 日志不输出
```yaml
# 检查日志配置
logging:
  level:
    org.endless: DEBUG
```

#### 3. 依赖冲突
```xml
<!-- 排除冲突的依赖 -->
<exclusions>
    <exclusion>
        <groupId>conflicting-group</groupId>
        <artifactId>conflicting-artifact</artifactId>
    </exclusion>
</exclusions>
```

#### 4. 数据库连接失败
```yaml
# 检查数据源配置
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database
    username: your_username
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

#### 5. 安全配置问题
```yaml
# 检查安全配置
spring:
  security:
    user:
      name: admin
      password: admin
```

## 📚 API 文档

### 核心注解

- `@EnableEndlessDDD`: 启用 DDD 功能
- `@Aggregate`: 标记聚合根
- `@Entity`: 标记实体
- `@ValueObject`: 标记值对象
- `@Repository`: 标记仓储接口
- `@LogExecution`: 记录执行日志
- `@DomainService`: 标记领域服务
- `@ApplicationService`: 标记应用服务
- `@QueryService`: 标记查询服务

### 核心接口

- `Repository<T, ID>`: 仓储基础接口
- `ApplicationService`: 应用服务接口
- `QueryService`: 查询服务接口
- `DomainService`: 领域服务接口
- `Command`: 命令接口
- `Query`: 查询接口
- `Result<T>`: 结果包装器

### 工具类

- `IdGenerator`: ID 生成器
- `CryptoUtils`: 加密工具
- `DataUtils`: 数据处理工具
- `ModelUtils`: 模型工具
- `SecurityUtils`: 安全工具
- `LogUtils`: 日志工具

### 异常类

- `DomainException`: 领域异常
- `ApplicationException`: 应用异常
- `InfrastructureException`: 基础设施异常
- `ValidationException`: 验证异常
- `NotFoundException`: 未找到异常

## 🔗 相关链接

- **项目主页**: [返回总体项目](./README.md)
- **生成器项目**: [EndlessDDD Generator](../endless-ddd-generator/README.md)
- **桌面应用**: [EndlessDDD Generator UI](../endless-ddd-generator-ui/README.md)
- **GitHub 仓库**: [https://github.com/org-endless/endless-ddd](https://github.com/org-endless/endless-ddd)

---

**Happy Coding! 🚀** 