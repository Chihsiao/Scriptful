package net.aegistudio.scriptful;

import javax.script.Invocable;

public class MethodExecutor implements Executor<MethodExecutor> {
	public final Invocable script;
	public final Object instance;
	public final String function;
	
	public MethodExecutor(Invocable script, Object instance, String method) {
		this.script = script;
		this.instance = instance;
		this.function = method;
	}
	
	@Override
	public void execute(Object... arguments) throws Exception {
		script.invokeMethod(instance, function, arguments);
	}
	
	public int compareTo(MethodExecutor another) {
		int compareFirst = script.hashCode() - another.script.hashCode();
		if(compareFirst != 0) return compareFirst;
		
		int compareSecond = instance.hashCode() - another.instance.hashCode();
		if(compareSecond != 0) return compareSecond;
		
		return function.compareTo(another.function);
	}
}
