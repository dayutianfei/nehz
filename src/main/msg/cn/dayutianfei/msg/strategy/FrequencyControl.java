package cn.dayutianfei.msg.strategy;

/**
 * FrequencyControl: 频率控制
 * @author dayutianfei
 *
 */
public class FrequencyControl {
	private long beginTime = 0L;
	private long cacheTime = 0L;
	
	public FrequencyControl(long cacheTime) {
		this.cacheTime = cacheTime;
		this.beginTime = System.currentTimeMillis();
	}
	
	public boolean meetTheCondition(){
		if((System.currentTimeMillis()-beginTime)>= cacheTime){
			beginTime = System.currentTimeMillis();
			return true;
		}else{
			return false;
		}
	}
	public void resetBeginTime(){
		this.beginTime = System.currentTimeMillis();
	}
}
