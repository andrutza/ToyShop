package toyshop.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ToyShopWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	  @Override
	  protected Class<?>[] getRootConfigClasses() {
	    return new Class<?>[] { RootConfig.class };
	  }

	  @Override
	  protected Class<?>[] getServletConfigClasses() {
	    return new Class<?>[] { WebConfig.class };
	  }

	  @Override
	  protected String[] getServletMappings() {
	    return new String[] { "/" };
	  }
}
