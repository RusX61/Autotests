package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendPageData{

	@SerializedName("sendPageData")
	private List<SendPageDataItem> sendPageData;

	public void setSendPageData(List<SendPageDataItem> sendPageData){
		this.sendPageData = sendPageData;
	}

	public List<SendPageDataItem> getSendPageData(){
		return sendPageData;
	}

	@Override
 	public String toString(){
		return
			"SendPageData{" +
			"sendPageData = '" + sendPageData + '\'' +
			"}";
		}
}
