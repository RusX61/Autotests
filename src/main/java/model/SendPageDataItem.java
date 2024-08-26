package model;

import com.google.gson.annotations.SerializedName;

public class SendPageDataItem{

	@SerializedName("date")
	private  String date;

	@SerializedName("resultValue")
	private  String resultValue;

	@SerializedName("coldWater")
	private  String coldWater;

	@SerializedName("electric")
	private  String electric;

	@SerializedName("gas")
	private  String gas;

	@SerializedName("hotWater")
	private  String hotWater;

	public void setDate(String date){
		this.date = date;
	}

	public  String getDate(){
		return date;
	}

	public void setResultValue(String resultValue){
		this.resultValue = resultValue;
	}

	public  String getResultValue(){
		return resultValue;
	}

	public void setColdWater(String coldWater){
		this.coldWater = coldWater;
	}

	public  String getColdWater(){
		return coldWater;
	}

	public void setElectric(String electric){
		this.electric = electric;
	}

	public  String getElectric(){
		return electric;
	}

	public void setGas(String gas){
		this.gas = gas;
	}

	public  String getGas(){
		return gas;
	}

	public void setHotWater(String hotWater){
		this.hotWater = hotWater;
	}

	public  String getHotWater(){
		return hotWater;
	}

	@Override
 	public String toString(){
		return
			"SendPageDataItem{" +
			"date = '" + date + '\'' +
			",resultValue = '" + resultValue + '\'' +
			",coldWater = '" + coldWater + '\'' +
			",electric = '" + electric + '\'' +
			",gas = '" + gas + '\'' +
			",hotWater = '" + hotWater + '\'' +
			"}";
		}
}
