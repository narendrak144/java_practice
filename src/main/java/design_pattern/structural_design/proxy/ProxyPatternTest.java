package design_pattern.structural_design.proxy;

public class ProxyPatternTest {

	public static void main(String...strings){
		CommandExecutor executor =new CommandExecutorProxy("narendra", "wrong_pass");
		try {
			executor.runCommand("dir");
			executor.runCommand("rm -rf narednra.pdf");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Message::"+e.getMessage());
		}
	}
}
