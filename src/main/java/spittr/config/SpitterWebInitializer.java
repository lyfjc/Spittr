package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;

/**
 * 容器会查找实现ServletContainerInitializer接口的类
 * Spring提供了这个接口的实现，即SpringServletContainerInitializer
 * Spring提供的实现，会查找实现WebApplicationInitializer的类并将配置
 * 任务交给他们
 * Spring引入了一个便利的实现，即AbstractAnnotationConfigDispatcherServletInitializer
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  /*
  ContextLoaderListener创建另一个应用上下文
  加载的bean：驱动应用后端的中间层和数据层组件
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

  /*
  要求DispatcherServlet加载应用上下文时，使用定义
  在WebConfig配置类中的bean
  （web组件的bean，如控制器、视图解析器及处理器映射）
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  /*
  用于将若干个路径映射到DispatcherServlet上
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}