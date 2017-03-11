package ch.javaee.helloWorldTutorial.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="indexBean")
@RequestScoped
public class IndexBean {
	private String world = "Hello World!! JFS example.. ";
	public String getWorld() {
		return world;
	}
}
