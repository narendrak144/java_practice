package design_pattern.structural_design.proxy;


public class CommandExecutorImpl implements CommandExecutor{

	public CommandExecutorImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void runCommand(String cmd) throws Exception {
		// TODO Auto-generated method stub
		//Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}

}
