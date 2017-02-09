package com.godsungchun.mongodb.example.entities.mongodb.prop.blogContents;

import java.io.Serializable;

public class SectionCodeProperty implements Serializable {
		private static final long serialVersionUID = -7513021120962181395L;
		private String code;
		private String code1;
		private String code2;
		
		public String getCode() {
			return code;
		}
		
		public void setCode(String code) {
			this.code = code;
		}
		
		public String getCode1() {
			return code1;
		}
		
		public void setCode1(String code1) {
			this.code1 = code1;
		}
		
		public String getCode2() {
			return code2;
		}
		
		public void setCode2(String code2) {
			this.code2 = code2;
		}
	}