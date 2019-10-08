package controller;

import java.util.Iterator;
import java.util.List;

import entity.Address;
import entity.User;
import model.AddressModel;
import model.UserModel;

public class ManageUser {

	public static void main(String[] args) {

		AddressModel addressModel = new AddressModel();
		Address address1 = addressModel.add("Thai Nguyen", 250000);
		Address address2 = addressModel.add("Ha Noi", 100000);

		UserModel userModel = new UserModel();

		userModel.add("Kien", address1);
		userModel.add("Hiep", address2);
		userModel.add("Dieu", address2);

		List<?> users = userModel.list();
		for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {

			User user = (User) iterator.next();
			System.out.println("------------------");
			System.out.println("ID: " + user.getUserId());
			System.out.println("NAME: " + user.getName());
			System.out.println("ADDRESS: " + user.getAddress().getCity());
		}

		userModel.update(11, address1);
		users = userModel.list();
		for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {

			User user = (User) iterator.next();
			System.out.println("------------------");
			System.out.println("ID: " + user.getUserId());
			System.out.println("NAME: " + user.getName());
			System.out.println("ADDRESS: " + user.getAddress().getCity());
		}
	}
}
