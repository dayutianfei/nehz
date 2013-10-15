package cn.dayutianfei.api;

public interface FileDeliver {
	public boolean put(byte[] file);
	public byte[] get(String fileName);
}
