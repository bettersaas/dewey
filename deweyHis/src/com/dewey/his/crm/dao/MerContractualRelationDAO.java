package com.dewey.his.crm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.dewey.his.crm.model.MerContractualRelation;
import com.dewey.his.param.model.RoomType;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("merContractualRelationDAO")
public class MerContractualRelationDAO extends Hibernate3Dao {

//	public List<MerContractualRelation> getContractualRelationByUnitId(Long unitId) {
//		List<MerContractualRelation> rtnList = new ArrayList<MerContractualRelation>();
//		String queryString = "select model1,model2 from RoomType as model1 left outer join model1.merContractualRelations as model2 where model2.contractualUnit.id=?  order by model1.id";   
//		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
//		query.setParameter(0, unitId);
//		Iterator<?> rstList = query.list().iterator();
//		while (rstList.hasNext()) {
//			Object[] objArray = (Object[]) rstList.next();
//			if (objArray != null) {
//				RoomType roomType = (RoomType)objArray[0];
//				MerContractualRelation merContractualRelation = (MerContractualRelation)objArray[1];
//				merContractualRelation.setRoomType(roomType);
//				rtnList.add(merContractualRelation);
//			}
//		}
//		return rtnList;
//	}
	
	@SuppressWarnings("unchecked")
	public List<MerContractualRelation> getContractualRelationByUnitId(Long unitId, Long  roomTypeId) {
		List<MerContractualRelation> rtnList = new ArrayList();
		String sqlStr = "select   t1.id as ID1," +
		 "   t1.allday_per_hour_price as ALLDAY2," +
		 "   t1.allday_price as ALLDAY3," +
		 "   t1.comment as COMMENT5," +
		 "   t1.halfday_per_hour_price as HALFDAY5," +
		 "   t1.halfday_price as HALFDAY6," +
		 "   t1.hour_measure as HOUR7," +
		 "   t1.hour_per_hour_price as HOUR8," +
		 "   t1.hour_price as HOUR9," +
		 "   t1.mer_id as MER12," +
		 "   t1.name as NAME5," +
		 "   t1.room_type_desc as ROOM11," +
		 "   t2.id as ID2," +
		 "  case   WHEN t2.contractual_price is null THEN t1.allday_price " +
		 "  	       ELSE  t2.contractual_price " +
		 "   END as CONTRACT2," +
		 "   t2.contractual_unit_id as CONTRACT4," +
		 "   t2.mer_id as MER3," +
		 "   t2.room_type_id as ROOM5" +
		 "   from room_type t1  left outer join  (select * from mer_contractual_relation where contractual_unit_id=?)  t2  on t1.id=t2.room_type_id ";
		if (roomTypeId != null) {
			sqlStr = sqlStr + "  where t1.id=? order by t1.id ";
		} else {
			sqlStr = sqlStr + "  order by t1.id ";
		}
		SQLQuery  sqlQuery = this.getSession().createSQLQuery(sqlStr);
		sqlQuery.addScalar("ID1" , new LongType());
		sqlQuery.addScalar("ALLDAY2" , new DoubleType());
		sqlQuery.addScalar("ALLDAY3" , new DoubleType());
		sqlQuery.addScalar("COMMENT5" , new org.hibernate.type.StringType());
		sqlQuery.addScalar("HALFDAY5" , new DoubleType());
		sqlQuery.addScalar("HALFDAY6" , new DoubleType());
		sqlQuery.addScalar("HOUR7" , new IntegerType());
		sqlQuery.addScalar("HOUR8" , new DoubleType());
		sqlQuery.addScalar("HOUR9" , new DoubleType());
		sqlQuery.addScalar("MER12" , new LongType());
		sqlQuery.addScalar("NAME5" , new StringType());
		sqlQuery.addScalar("ROOM11" , new StringType());
		sqlQuery.addScalar("ID2" , new LongType());
		sqlQuery.addScalar("CONTRACT2" , new DoubleType());
		sqlQuery.addScalar("CONTRACT4" , new LongType());
		sqlQuery.addScalar("MER3" , new LongType());
		sqlQuery.addScalar("ROOM5" , new LongType());
		Query query = sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setParameter(0, unitId);
		if (roomTypeId != null) {
			query.setParameter(1, roomTypeId);
		}
		List<Map<String, ?>> listMap = query.list();
		for (int i=0; i<listMap.size(); i++) {
			Map<String, ?> map = listMap.get(i);
			RoomType roomType = new RoomType();
			roomType.setId((Long)map.get("ID1"));
			roomType.setName((String)map.get("NAME5"));
			roomType.setAlldayPrice((Double)map.get("ALLDAY3"));
			MerContractualRelation cr = new MerContractualRelation();
			cr.setId((Long)map.get("ID2"));
			cr.setContractualPrice((Double)map.get("CONTRACT2"));
			cr.setMerId((Long)map.get("MER3"));
			cr.setRoomType(roomType);
			rtnList.add(cr);
		}
		return rtnList;
	}
}
