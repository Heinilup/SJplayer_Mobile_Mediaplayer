package com.zousj.sjplayer.domain;

public class VideoItem {
	
	//����
	private String title;
	//ʱ��
	private String duration;
	//�ļ���С
	private long size;
	//������ַ
	private String data;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "VideoItem [title=" + title + ", duration=" + duration
				+ ", size=" + size + ", data=" + data + "]";
	} 

}
