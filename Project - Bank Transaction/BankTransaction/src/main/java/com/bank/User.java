package com.bank;

	// User class --> Data Model
	public class User {
		
		// Attributes
		private int t_id;
		private String t_type;
		private float amount;
		private float balance;
		private static float totalBalance;
		
		// No argument Constructor
		public User() {
			
		}
		
		// 4 - Argument Constructor
		public User(int t_id, String t_type, float amount, float balance) {
			this.t_id = t_id;
			this.t_type = t_type;
			this.amount = amount;
			this.balance = balance;
		}
		
		// Getters and Setters
		public static float getTotalBalance() {
			return totalBalance;
		}
		public void setTotalBalance(float totalBalance) {
			this.totalBalance = totalBalance;
		}
		public int getT_id() {
			return t_id;
		}
		public void setT_id(int t_id) {
			this.t_id = t_id;
		}
		public String getT_type() {
			return t_type;
		}
		public void setT_type(String t_type) {
			this.t_type = t_type;
		}
		public float getAmount() {
			return amount;
		}
		public void setAmt(float amount) {
			this.amount = amount;
		}
		public float getBalance() {
			return balance;
		}
		public void setBal(float balance) {
			this.balance = balance;
		}
		
	}


