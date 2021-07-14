package Exercise10;

import java.lang.reflect.Method;

public class SimpleUnitTester {

	public int execute(Class clazz) throws Exception {
		int failedCount = 0;

		// your code
		Object object = null;
		Object result;
		object = clazz.newInstance();
		for (Method m : clazz.getDeclaredMethods()) {
			if (m.getName().contains("test") || m.getReturnType().equals(boolean.class)) {
				if (!m.getName().startsWith("test")) {
					break;
				}
				result = m.invoke(object, m);
				if ((boolean) (result = false)) {
					failedCount++;
				}
			}
		}
		return failedCount;
	}

}
