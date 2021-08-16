package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the VEHICLE_MODEL_PG database table.
 * 
 */
@Entity
@Table(name="VEHICLE_MODEL_PG")
@NamedQuery(name="VehicleModelPg.findAll", query="SELECT v FROM VehicleModelPg v")
public class VehicleModelPg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MODEL_ID")
	private Long modelId;

	private String depcription;

	@Column(name="EX_SHOWROOM_PRICE")
	private Integer exShowroomPrice;

	@Column(name="MODEL_NAME")
	private String modelName;

	@Column(name="ON_ROAD_PRICE")
	private Integer onRoadPrice;

	@Column(name="VEHICLE_COMPANY_NAME")
	private String vehicleCompanyName;

	@Column(name="VEHICLE_TYPE")
	private String vehicleType;

	//bi-directional many-to-one association to ApplicationDetPg
	@OneToMany(mappedBy="vehicleModelPg", fetch=FetchType.EAGER)
	private List<ApplicationDetPg> applicationDetPgs;

	public VehicleModelPg() {
	}

	public Long getModelId() {
		return this.modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getDepcription() {
		return this.depcription;
	}

	public void setDepcription(String depcription) {
		this.depcription = depcription;
	}

	public Integer getExShowroomPrice() {
		return this.exShowroomPrice;
	}

	public void setExShowroomPrice(Integer exShowroomPrice) {
		this.exShowroomPrice = exShowroomPrice;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Integer getOnRoadPrice() {
		return this.onRoadPrice;
	}

	public void setOnRoadPrice(Integer onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}

	public String getVehicleCompanyName() {
		return this.vehicleCompanyName;
	}

	public void setVehicleCompanyName(String vehicleCompanyName) {
		this.vehicleCompanyName = vehicleCompanyName;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@JsonIgnore
	public List<ApplicationDetPg> getApplicationDetPgs() {
		return this.applicationDetPgs;
	}

	public void setApplicationDetPgs(List<ApplicationDetPg> applicationDetPgs) {
		this.applicationDetPgs = applicationDetPgs;
	}

	public ApplicationDetPg addApplicationDetPg(ApplicationDetPg applicationDetPg) {
		getApplicationDetPgs().add(applicationDetPg);
		applicationDetPg.setVehicleModelPg(this);

		return applicationDetPg;
	}

	public ApplicationDetPg removeApplicationDetPg(ApplicationDetPg applicationDetPg) {
		getApplicationDetPgs().remove(applicationDetPg);
		applicationDetPg.setVehicleModelPg(null);

		return applicationDetPg;
	}

}