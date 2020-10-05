package cn.edu.xit.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.xit.entity.Address;
import cn.edu.xit.entity.Grade;
import cn.edu.xit.entity.Student;
import cn.edu.xit.entity.StudentBusiness;
import cn.edu.xit.entity.StudentClass;

//操作Mybatis的接口
public interface StudentMapper {
	/*1.方法名和mapper.xml文件中标签的id值相同
	 *2.方法的 输入参数 和mapper.xml文件中标签的 parameterType类型一致
	 * 3.方法的返回值  和 mapper.xml文件中标签的resultType类型一致
	 * 
	 */
	//public static Student queryStudentByStuno(int stuNO);
	
	//查询一个学生
	Student queryStudentByStuno(int stuNO);
	//增加学生
	void addStrudent(Student student);
	//删除学生
	void deleteStudent(int stuNO);
	//修改学生
	void updateStudent(Student student);
	//查询全部学生
	List<Student> queryAllStudents();
	
	//===================属性名和字段名不同
	Student queryStudentByStunoWithConverter(int stuNo);
	
	Student queryStudentByAlias(int stuno);
	//===================属性名和字段名不同
	
	void addStrudentWithConverter(Student student);
	
	
	
	
	Student queryStudentByStuname(String stuname);
	//查询全部学生，根据姓名排序
	List<Student> queryStudentOrderByColumn(String column);
	//根据姓名或年龄查询学生
	List<Student> queryStudentOrderBystuAgeOrstuName(Student student);
	//嵌套对象查询
	//List<Student> queryStudentOrderByaddress(Address address);
	
	List<Student> queryStudentOrderByaddress(Student student);
	//输入参数为HashMap
	List<Student> queryStudentOrderBystuAgeOrstuNameWithHashMap(Map<String,Object> map);//String,Object
	//根据存储过程查询某个年级的学生总数
	void queryConutByGradeWithProcedure(Map<String,Object> params);
	//根据存储过程删除
	void deleteStudentBystunoWithProcedure(Map<String,Object> params);
	//别名作为Map的key  查询一个学生
	HashMap<String,Object> queryStudentOutByHashMap();
	//别名作为Map的key  查询多个学生
	List<HashMap<String,Object>> queryAllStudentsOutByHashMap();
	
	Student queryStuByNOrAWishSQLTag(Student student);
	
	List<Student> queryStudentsWithNosInGrade(Grade grade);
	//将多个对象放入数组中   int[]
	List<Student> queryStudentsWithArray(int[] stuNos);
	
	List<Student> queryStudentsWithList(List<Integer> stuNos);
	
	List<Student> queryStudentsWithObjectArray(Student[] student);
	//利用业务扩展类实现一对一关联查询
	StudentBusiness queryStudentByNoWithOO(int stuno);
	
	Student queryStudentByNoWithOO2(int stuNo);
	
	StudentClass queryClassAndStudents(int classId);
	
	List<Student> queryStudentWithOOLazyLoad();
}
