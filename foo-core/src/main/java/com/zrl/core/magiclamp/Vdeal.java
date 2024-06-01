package com.zrl.core.magiclamp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Vdeal {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {

		// file(内存)----输入流---->【程序】----输出流---->file(内存)

		try {

			BufferedReader br = new BufferedReader(
					new FileReader(new File("/Users/zhouriliang/Documents", "wpsid.log")));

			String tempString = null;

			Set<String> sidset = new HashSet<String>();

			int line = 0;

			while ((tempString = br.readLine()) != null) {

				line++;

				// tempString = "2017-12-21 00:00:40.087 [HSFBizProcessor-DEFAULT-8-thread-326]
				// ERROR CommonOperatorForLP.setResIdsByCndcp:179 - setResIdsByCndcp_next,
				// orderCode:LP00089896825181, sid:50000000001119, wsid:5000000000009,
				// sCode:CUSTOMS_12707771, nodeType:CUSTOMS, backGoodFlag:null, serviceType:4,
				// isV2D:false";

				if (!tempString.startsWith("2017")) {

					continue;

				}

				String[] strs = tempString.split(",");

				String stype = strs[7].split(":")[1];
				
				String backGoodFlagValue = strs[6].split(":")[1];
				
				if(!backGoodFlagValue.equals("null")) {
					System.out.println(tempString);
				}

//				if (sidset.contains(stype)) {
//
//					continue;
//
//				} else {
//
//					sidset.add(stype);
//
//				}
//
//				System.out.println(sidset);

				// String sid1 = strs[2].split(":")[1];

				//

				// String sid2 = strs[3].split(":")[1];

				//

				// if(sid1.equals(sid2)) {

				//

				// continue;

				//

				// }

				//

				// String aa = sid1+ "-" + sid2;

				//

				// if(sidset.contains(aa)) {

				//

				// continue;

				//

				// }

				//

				// sidset.add(aa);

				// System.out.println("line: " + line + ", " + tempString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
