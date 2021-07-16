package Practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {

	public static class JdkProxyCreator implements InvocationHandler {

		private Object target;

		public JdkProxyCreator(Object target) {
			super();
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("before");

			Object result = method.invoke(target, args);
			System.out.println("after");
			return result;
		}

		public Object getProxy() {
			Class<?> clazz = this.target.getClass();
			return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
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
		JdkProxyCreator jdkProxyCreator = new JdkProxyCreator(new User());
		UserAction user = (UserAction) jdkProxyCreator.getProxy();
		user.say();
	}

}
