package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "members")
public class Member {
	@Id
    private String membId;
    private String name;
    private String address;
    private String membType;
    private LocalDate membDate;
    private LocalDate expiryDate;
	public String getMembId() {
		return membId;
	}
	public void setMembId(String membId) {
		this.membId = membId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMembType() {
		return membType;
	}
	public void setMembType(String membType) {
		this.membType = membType;
	}
	public LocalDate getMembDate() {
		return membDate;
	}
	public void setMembDate(LocalDate membDate) {
		this.membDate = membDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Member [membId=" + membId + ", name=" + name + ", address=" + address + ", membType=" + membType
				+ ", membDate=" + membDate + ", expiryDate=" + expiryDate + "]";
	}
    
    
}
