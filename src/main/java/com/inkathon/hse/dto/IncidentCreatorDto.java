package com.inkathon.hse.dto;

public class IncidentCreatorDto {
		private int user_id;
		private int manager_id;
		private String name;
		private String password;
		private String address;
		private int mobile_no;
		
		
		
		public IncidentCreatorDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public IncidentCreatorDto(int user_id, int manager_id, String name, String password, String address,
				int mobile_no) {
			super();
			this.user_id = user_id;
			this.manager_id = manager_id;
			this.name = name;
			this.password = password;
			this.address = address;
			this.mobile_no = mobile_no;
		}


		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getManager_id() {
			return manager_id;
		}
		public void setManager_id(int manager_id) {
			this.manager_id = manager_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public int getMobile_no() {
			return mobile_no;
		}
		public void setMobile_no(int mobile_no) {
			this.mobile_no = mobile_no;
		}


		@Override
		public String toString() {
			return "IncidentCreatorDto [user_id=" + user_id + ", manager_id=" + manager_id + ", name=" + name
					+ ", password=" + password + ", address=" + address + ", mobile_no=" + mobile_no + "]";
		}
		

		
		
}
