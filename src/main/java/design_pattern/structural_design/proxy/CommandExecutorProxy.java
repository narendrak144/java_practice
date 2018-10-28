package design_pattern.structural_design.proxy;

public class CommandExecutorProxy implements CommandExecutor{

	private boolean isAdmin = false;
	private CommandExecutor executor;
	
	
	public CommandExecutorProxy(String user, String pass) {
		// TODO Auto-generated constructor stub
		if("narendra".equals(user) && "manav".equals(pass))
			isAdmin = true;
		
		executor =new CommandExecutorImpl();
	}
	
	@Override
	public void runCommand(String cmd) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("run the CommandExecutorProxy -> "+ isAdmin);;
		if(isAdmin){
			executor.runCommand(cmd);
		}else{
			System.out.println(cmd);
			if(cmd.trim().startsWith("rm"))
				throw new Exception("rm command is not allowed to non-admin users");
			else 
				executor.runCommand(cmd);
			
		}
	}

	
}
