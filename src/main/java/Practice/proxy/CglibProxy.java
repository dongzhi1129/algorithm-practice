package Practice.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy {

	public static class CglibProxyCreator {

		private Object target;

		private MethodInterceptor methodInterceptor;

		public CglibProxyCreator(Object target, MethodInterceptor methodInterceptor) {
			super();
			this.target = target;
			this.methodInterceptor = methodInterceptor;
		}

		public Object getProxy() {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(target.getClass());
			enhancer.setCallback(methodInterceptor);
			return enhancer.create();
		}

	}

	public static class Interceptor implements MethodInterceptor {

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			System.out.println("before");
			Object obj1 = proxy.invokeSuper(obj, args);
			System.out.println("after");
			return obj1;
		}

	}
	
	public static interface UserAction {
		void say();
	}

	public static class User implements UserAction {

		public void say() {
			System.out.println("Im User.");
		}
	}
	public static void main(String[] args) {
		CglibProxyCreator cglibProxyCreator = new CglibProxyCreator(new User(), new Interceptor());
		User user = (User) cglibProxyCreator.getProxy();
		user.say();
	}

}
