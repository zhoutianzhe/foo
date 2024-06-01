package com.zrl.core.magiclamp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ResourceFixTool {
	
	private static final Map<String, String> resourceMapping = new HashMap<String, String>();
	
	private static final Map<String, String> workIdResourceIdMapping = new HashMap<String, String>();
	
	private static String resourceMappingStr = "北京十八里店分拨中心,5000000380401\n" + 
			"CN-共享-北京马坡分拨中心,1216000000134395\n" + 
			"华东配-万象,5000000113073\n" + 
			"晟邦物流-美妆,5000000155459\n" + 
			"CN-品勤-北京西南分拨中心,1216000000133452\n" + 
			"山西建华快递服务有限公司,6000100041817\n" + 
			"万象-美妆,5000000106304\n" + 
			"万象-自营,5000000147582\n" + 
			"EMS-落地配,5000000383785  \n" + 
			"晟邦-快消,5000000183371\n" + 
			"圆通快递,5000000074954\n" + 
			"晟邦物流,100034131   \n" + 
			"展翔新都-重庆万象,1216000000132557\n" + 
			"万科分拨-重庆万象,1216000000134463\n" + 
			"CN-北领-天津空港分拨中心,1216000000126680\n" + 
			"山东递速供应链-天猫超市,6000100040325\n" + 
			"重货-吉林黄马甲,5000000179469\n" + 
			"顺丰-快递,5000000381395\n" + 
			"CN-共享-北京顺义分拨中心,6000100041387\n" + 
			"CN-建华-太原分拨中心,1216000000130390\n" + 
			"成都万科分拨-昆明东骏,1216000000134461\n" + 
			"中通,5000000074904\n" + 
			"圆通,5000000074954\n" + 
			"CN-EMS-石家庄分拨中心,1216000000132156\n" + 
			"展翔物流成昆线,1216000000126375\n" +
			"万象-上海-小家电,5000000074688\n" +
			"晟邦物流-天猫小家电,5000000074712\n" +
			"晟邦物流-天猫小家电,5000000074712\n" +
			"CN-黄马甲-长春分拨中心,1216000000132955\n" +
			"万科分拨-贵阳东骏,1216000000134462\n" +
			"芝麻开门,100034133\n" +
			"CN-品勤-江门鹤山分拨中心,1216000000128559\n" +
			"成都东骏快捷物流有限公司,100034181\n" +
			"韵达快运,100034174";

	private static String workOrderIdResourceNameStr = "100171221163204166	分拨	CN-北领-天津空港分拨中心\n" + 
			"100171220162957725	分拨	CN-北领-天津空港分拨中心\n" + 
			"100171221163204166	分拨	CN-北领-天津空港分拨中心\n" + 
			"100171220162957725	分拨	CN-北领-天津空港分拨中心\n" + 
			"100171222163354542	分拨	CN-共享-北京马坡分拨中心\n" + 
			"100171218162493694	分拨	CN-共享-北京顺义分拨中心\n" + 
			"100171218162607872	分拨	CN-共享-北京顺义分拨中心\n" + 
			"100171218162536764	分拨	CN-黄马甲-长春分拨中心\n" + 
			"100171221163180421	分拨	CN-黄马甲-长春分拨中心\n" + 
			"100171222163451963	分拨	CN-品勤-北京西南分拨中心\n" + 
			"100171223163666288	分拨	CN-品勤-北京西南分拨中心\n" + 
			"100171221163295921	分拨	CN-品勤-江门鹤山分拨中心\n" + 
			"100171221163295921	分拨	CN-品勤-江门鹤山分拨中心\n" + 
			"100171219162715910	分拨	北京十八里店分拨中心\n" + 
			"100171222163511599	分拨	北京十八里店分拨中心\n" + 
			"100171223163588705	分拨	北京十八里店分拨中心\n" + 
			"100171222163361247	分拨	北京十八里店分拨中心\n" + 
			"100171223163555297	分拨	北京十八里店分拨中心\n" + 
			"100171223163655316	分拨	北京十八里店分拨中心\n" + 
			"100171219162886251	分拨	北京十八里店分拨中心\n" + 
			"100171219162783328	分拨	北京十八里店分拨中心\n" + 
			"100171218162589085	分拨	北京十八里店分拨中心\n" + 
			"100171217162352100	分拨	北京十八里店分拨中心\n" + 
			"100171220163021164	分拨	北京十八里店分拨中心\n" + 
			"100171222163386233	分拨	北京十八里店分拨中心\n" + 
			"100171220163099216	分拨	北京十八里店分拨中心\n" + 
			"100171222163477910	分拨	北京十八里店分拨中心\n" + 
			"100171219162886251	分拨	北京十八里店分拨中心\n" + 
			"100171220163136111	分拨	北京十八里店分拨中心\n" + 
			"100171221163300765	分拨	北京十八里店分拨中心\n" + 
			"100171221163268833	配送	成都东骏快捷物流有限公司\n" + 
			"100171221163268833	配送	成都东骏快捷物流有限公司\n" + 
			"100171218162605038	配送	山西建华快递服务有限公司\n" + 
			"100171222163493706	配送	顺丰-快递\n" + 
			"100171217162312471	配送	万象-美妆\n" + 
			"100171222163354542	配送	万象-上海-小家电\n" + 
			"100171220163015369	配送	万象-自营\n" + 
			"100171219162867561	配送	圆通\n" + 
			"100171214161578389	配送	圆通\n" + 
			"100171219162867561	配送	圆通";
	
	
	public static void main(String[] args) {
		initResouceMapping();
		System.out.println("==================================以下不能提取的======================");
		extractWorkOrderIdResourceMap();
		System.out.println("==================================以下為訂正SQL，数量："+ workIdResourceIdMapping.size() + "======================");
		printSql();
	}
	
	private static void initResouceMapping(){
		
		String[] resouceMappingPairs = resourceMappingStr.split("\n");
		
		for (String wr : resouceMappingPairs) {
			
			String[] wrToken = wr.trim().split(",");

			String name = wrToken[0].trim();

			String rid = wrToken[1].trim();
			
			resourceMapping.put(name, rid);
			
		}
	}
	
	private static void extractWorkOrderIdResourceMap(){
		
		String[] resouceNameMappingPairs = workOrderIdResourceNameStr.split("\n");
		
		for (String wr : resouceNameMappingPairs) {
			
			String[] rnToken = wr.trim().split("	");

			String wid = rnToken[0];

//			String type = rnToken[1];
			
			String rname = rnToken[2];
			
			String rid = resourceMapping.get(rname.trim());
			
			if(rid == null) {
				System.out.println(wr);
			}else {
				workIdResourceIdMapping.put(wid, rid);
			}
		}
	}
	
	private static void printSql(){
		
		for(Map.Entry<String, String> entry : workIdResourceIdMapping.entrySet()) {
			String id = entry.getKey();
			String rid = entry.getValue();
			String sql = "UPDATE wp_work_order SET features = ( CASE WHEN features like '%TRUNK%' THEN REPLACE(features,'TRUNK:','TRUNK:"
					+ rid + ",') else CONCAT(features,'TRUNK:" + rid + "',';') end ) where id = " + id + ";";

			System.out.println(sql);
		}
		
	}
		
	
	

	
	
	
	
	
	
	private static String WorkOrderIdResourcePairStr = "100171214161570173,5000000383785\n" + 
			"100171217162373124,5000000074954\n" + 
			"100171214161578389,5000000074954";
	
	public static void parseMethod2() {
		
		Set<String> set = new HashSet<String>();
		
		String[] workOrderIdResourcePairs = WorkOrderIdResourcePairStr.split("\n");
		
		for (String wr : workOrderIdResourcePairs) {
			
			if(set.contains(wr)) {
				continue;
			}else {
				set.add(wr);
			}
			
			String[] wrToken = wr.trim().split(",");

			String id = wrToken[0];

			String rid = wrToken[1];

			String sql = "UPDATE wp_work_order SET features = ( CASE WHEN features like '%TRUNK%' THEN REPLACE(features,'TRUNK:','TRUNK:"
					+ rid + ",') else CONCAT(features,'TRUNK:" + rid + "',';') end ) where id = '" + id + "';";

			System.out.println(sql);

		}

	}

}