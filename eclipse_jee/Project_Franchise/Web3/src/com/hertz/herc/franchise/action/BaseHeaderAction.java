package com.hertz.herc.franchise.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.hertz.herc.franchise.info.Nav;
import com.hertz.herc.franchise.info.NavItem;
import com.hertz.herc.franchise.util.LogBroker;

@Namespace("/")
public class BaseHeaderAction extends BaseAction {
	private static final long serialVersionUID = 1675015934631895865L;
	private static Class<?> classRef = BaseHeaderAction.class;

	private Nav nav = new Nav();
	public Nav getNav () {return nav;}

	private String omnitureTagName;
	public String getOmnitureTagName() {return omnitureTagName;}

	private String imageName;
	public String getImageName() {return imageName;}

	private String altText;
	public String getAltText() {return altText;}

	@Action(value = "home_jv", results = { @Result(name = "success", location = "http://struts.apache.org", type = "redirect") })
	public String home_jv () {
		task(1);
		return SUCCESS;
	}

	@Action(value="jv_url", results={@Result(location="test_url_test.page", type="tiles")})
	public String jv_url () {
		return SUCCESS;
	}
	@Action(value="jv", results={@Result(location="test.simple.page", type="tiles")})
	public String jv () {
		return SUCCESS;
	}
	@Action(value="jv2", results={@Result(location="test.page", type="tiles")})
	public String jv2 () {
		return SUCCESS;
	}

	@Actions({
	    @Action(value="", results={@Result(name="success", location="home.home", type="tiles")}),
	    @Action(value="home", results={@Result(name="success", location="home.home", type="tiles")})
	  })
//	@Action(value="home", results={@Result(name="success", location="home.home", type="tiles")})
	public String home () {
		task(1);
		return SUCCESS;
	}
	@Action(value="our-company", results={@Result(name="success", location="home.history", type="tiles")})
	public String company () {
		task(2);
		return SUCCESS;
	}
	@Action(value="franchise-program", results={@Result(name="success", location="home.provenSystem", type="tiles")})
	public String franchiseProgram () {
		task(3);
		return SUCCESS;
	}
	@Action(value="buying-a-franchise", results={@Result(name="success", location="home.whatItTakes", type="tiles")})
	public String franchiseBuy () {
		task(4);
		return SUCCESS;
	}
	@Action(value="franchisee-benefits", results={@Result(name="success", location="home.whatYouWillReceive", type="tiles")})
	public String franchiseBenefits () {
		task(5);
		return SUCCESS;
	}

	public void task (int selected) {
		LogBroker.debug (classRef, ">>> BaseHeaderAction::execute");
		super.task ();
		switch (selected) {
			case 7:
				omnitureTagName = "franchise contact us confirmation";
				imageName = "hertz-equipment-franchise-contact-us.jpg";
				altText = "Hertz Equipment Franchise Contact Us";
				break;
			case 6:
				omnitureTagName = "franchise contact us";
				imageName = "hertz-equipment-franchise-contact-us.jpg";
				altText = "Hertz Equipment Franchise Contact Us";
				break;
			case 5:
				omnitureTagName = "franchise benefits";
				imageName = "hertz-equipment-franchisee-benefits.jpg";
				altText = "Hertz Equipment Franchisee Benefits";
				break;
			case 4:
				omnitureTagName = "franchise buying";
				imageName = "buying-an-equipment-rental-franchise.jpg";
				altText = "Buying An Equipment Rental Franchise";
				break;
			case 3:
				omnitureTagName = "franchise program";
				imageName = "hertz-equipment-franchise-program.jpg";
				altText = "Hertz Equipment Franchise Program";
				break;
			case 2:
				omnitureTagName = "franchise our company";
				imageName = "hertz-equipment-company-information.jpg";
				altText = "Hertz Equipment Company Information";
				break;
			case 1:
			default:
				omnitureTagName = "franchise opportunities home";
				imageName = "equipment-rental-franchise-opportunities.jpg";
				altText = "Equipment Rental Franchise Opportunities";
				break;
		}

		nav.add (new NavItem ("Franchise Opportunity", "home", selected == 1, true));
		nav.add (new NavItem ("Our Company", "our-company", selected == 2, true));
		nav.add (new NavItem ("Franchise Program", "franchise-program", selected == 3, true));
		nav.add (new NavItem ("Buying a Franchise", "buying-a-franchise", selected == 4, true));
		nav.add (new NavItem ("Franchisee Benefits", "franchisee-benefits", selected == 5, true));
		nav.add (new NavItem ("Contact Us", "contact-us", selected == 6 || selected == 7, true));
		LogBroker.debug (classRef, "<<< BaseHeaderAction::execute");
	}
}
