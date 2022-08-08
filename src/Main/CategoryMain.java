package Main;

import Frame.Frame_Base;
import Frame.Frame_Category;
import Frame.Frame_login;
import user.Userinfo;

public class CategoryMain {

	public static void main(String[] args) {

		Userinfo u=new Userinfo();
		Frame_Base.getInstance(new Frame_Category(u));
		
	}
	
}
