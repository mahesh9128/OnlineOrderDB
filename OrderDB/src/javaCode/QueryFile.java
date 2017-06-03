package javaCode;



public interface QueryFile {
	
	String loginquery = "SELECT U.privilege FROM `dbproject`.`user` as U WHERE U.userName= ? and U.pwd = ? ;";

	String query1="SELECT R.restId,R.name,R.cuisine,R.status,R.address,RT.openTime,RT.closeTime "+
			"FROM `dbproject`.`restaurant` as R, `dbproject`.`rest_timings` as RT "+
			"WHERE R.restId=RT.restId and address like ? and R.cuisine= ? "+
			"order by R.name ";

	String query2="SELECT R.name,R.cuisine,R.status,R.address,RT.openTime,RT.closeTime "+
			"FROM `dbproject`.`restaurant` as R, `dbproject`.`rest_timings` as RT "+
			"WHERE R.restId=RT.restId and R.cuisine= ? and CURTIME() BETWEEN "+ 
			"RT.openTime and RT.closeTime;";

	String query3="SELECT R.name,M.comboId,M.appetizer,M.mainCourse,M.dessert,M.price "+
			"FROM `dbproject`.`restaurant` as R,`dbproject`.`menu` as M "+
			"WHERE R.restId=M.restId and R.cuisine= ? "+
			"GROUP BY M.comboId "+
			"HAVING M.price < ? ;";

	String query4="SELECT R.name,D.comboId,D.discount "+
			"FROM `dbproject`.`restaurant` as R,`dbproject`.`discount` as D "+
			"WHERE R.restId=D.restId and R.name= ? and D.comboId= ?  and D.day= ? ;";

	String query5="SELECT R.name as RESTAURANT,avg(rating) as OVERALL_RATING "+
			"FROM `dbproject`.`restaurant` as R,`dbproject`.`review` as RV "+
			"WHERE R.restId=RV.restId "+
			"GROUP BY R.name "+
			"ORDER BY OVERALL_RATING;";

	String query6="SELECT C.fname,C.address "+
			"FROM `dbproject`.`customer` as C,`dbproject`.`order` as O "+
			"WHERE C.custId=O.custId and O.orderNum= ? ;";

	String query7="SELECT COUNT(*) as No_of_pending_orders "+
			"FROM `dbproject`.`order` as O "+
			"WHERE O.status='pending';";

	String query7_2="SELECT  orderNum "+
			"FROM `dbproject`.`order` as O "+
			"WHERE O.status='pending';";

	String query8="select RESTAURANT_NAME,Rating from "+
			"`dbproject`.`high_rating_view` "+
			"where Rating in (SELECT max(Rating) from "+
			"`dbproject`.`high_rating_view`);";

	String query9="SELECT O.comboId,O.custId,O.orderNum,O.restId "+
			"FROM `dbproject`.`customer` as C,`dbproject`.`order` as O "+
			"WHERE C.custId=O.custId and C.address like ? and O.status='pending'; ";

	String query10="SELECT RV.custId,R.name,RV.comment,RV.rating "+
			"FROM `dbproject`.`restaurant` as R,`dbproject`.`review` as RV "+
			"WHERE R.restId=RV.restId and R.name = ? "+
			"GROUP BY RV.custId;";
	
	String query11="{call `dbproject`.`cancel_order`( ? )}";

}
