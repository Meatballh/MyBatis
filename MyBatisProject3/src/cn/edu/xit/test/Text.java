package cn.edu.xit.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.edu.xit.entity.Address;
import cn.edu.xit.entity.Grade;
import cn.edu.xit.entity.Student;
import cn.edu.xit.entity.StudentBusiness;
import cn.edu.xit.entity.StudentCard;
import cn.edu.xit.entity.StudentClass;
import cn.edu.xit.mapper.StudentClassMapper;
import cn.edu.xit.mapper.StudentMapper;

public class Text {
	
	
	
	
	
	//查询单个学生
	public static void queryStudentByStuno() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
				
//				String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
				
				StudentMapper studentmapper = session.getMapper(StudentMapper.class);
				Student student = studentmapper.queryStudentByStuno(1);//接口中的方法--->SQL语句
				
				System.out.println(student);
				session.close();
	}
	
	//查询单个学生====属性名和字段名不同====
		public static void queryStudentByAlias() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//					String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					Student student = studentmapper.queryStudentByAlias(1);//接口中的方法--->SQL语句
					
					System.out.println(student);
					session.close();
		}
	
	//查询多个学生
	public static void queryAllStudents() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
				
//				String statemen = "cn.edu.xit.studentMapper.queryAllStudents";
				
				StudentMapper studentmapper = session.getMapper(StudentMapper.class);
				List<Student> studnets = studentmapper.queryAllStudents();
				
				System.out.println(studnets);
				session.close();
	}
	
	//增加学生
	public static void addStudent() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
				
//				String statemen = "cn.edu.xit.studentMapper.addStrudent";
				
				Student student = new Student(4,"zl",12,"jh");
				StudentMapper studentmapper = session.getMapper(StudentMapper.class);
				studentmapper.addStrudent(student);
				
//				int count = session.insert(statemen, studnet);
				
				session.commit();//提交事务
				System.out.println("增加成功");
				
				session.close();
	}
	
	//删除学生
	public static void deleteStudentByStuno() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
				
//				String statemen = "cn.edu.xit.studentMapper.deleteStudent";
				
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				studentMapper.deleteStudent(2);
				
//				int count = session.delete(statemen,3);
				
				session.commit();//提交事务
				System.out.println("删除成功");	
				session.close();
	}
	
	//修改学生
	public static void updateStudentByStuno() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
//				String statemen = "cn.edu.xit.studentMapper.updateStudent";
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				//修改的参数
				Student student = new Student();
				//修改哪个人，where stuno=？
				student.setStuNo(4);
				//修改成什么样子？
				student.setStuName("nike");
				student.setStuAge(112);
				student.setGraName("xit");
				studentMapper.updateStudent(student);
//				int count = session.update(statemen, student);
				session.commit();//提交事务
				System.out.println("修改成功");
				
				session.close();
	}
		
	
	
	
	
	//查询单个学生(使用了转化器)
	public static void queryStudentByStunoWithConverter() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
				
//					String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
				
				StudentMapper studentmapper = session.getMapper(StudentMapper.class);
				Student student = studentmapper.queryStudentByStunoWithConverter(1);//接口中的方法--->SQL语句
				
				System.out.println(student);
				session.close();
	}

		
		//增加学生(使用了转化器)
	public static void addStudentWithConverter() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
				
//					String statemen = "cn.edu.xit.studentMapper.addStrudent";
				
				Student student = new Student(8000,"limng",18,"kj");
				StudentMapper studentmapper = session.getMapper(StudentMapper.class);
				studentmapper.addStrudentWithConverter(student);
				student.setStuSex(true);
//					int count = session.insert(statemen, studnet);
				
				session.commit();//提交事务
				System.out.println("增加成功");
				
				session.close();
	}
	
		
		// =============两种取值符号以及ParameterType为简单、对象、嵌套对象类型=================
		//查询单个学生
	public static void queryStudentByStuname() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
				
//					String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
				
				StudentMapper studentmapper = session.getMapper(StudentMapper.class);
				Student student = studentmapper.queryStudentByStuname("nike");//接口中的方法--->SQL语句
				
				System.out.println(student);
				session.close();
	}
	
		
		//查询全部学生，根据姓名排序
	public static void queryStudentOrderByColumn() throws IOException{
		//Connection  -   SqlSession操作MyBatis
				//conf.xml  - > reader(将一个文件变成一个对象)
				Reader reader = Resources.getResourceAsReader("conf.xml");
				//reader   - > SqlSession
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession( );
				
//					String statemen = "cn.edu.xit.studentMapper.queryAllStudents";
				
				StudentMapper studentmapper = session.getMapper(StudentMapper.class);
				List<Student> studnets = studentmapper.queryStudentOrderByColumn("stuno");
				
				System.out.println(studnets);
				session.close();
	}
		
		
		//根据姓名或年龄查询学生
		public static void  queryStudentOrderBystuAgeOrstuName() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryAllStudents";
					Student student = new Student();
					student.setStuAge(12);
					student.setStuName("j");
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					List<Student> studnets = studentmapper.queryStudentOrderBystuAgeOrstuName(student);
					
					System.out.println(studnets);
					session.close();
		}
		
		
				
		//根据姓名或年龄查询学生， 输入参数为HashMap
		public static void  queryStudentOrderBystuAgeOrstuNameWithHashMap() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
							SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
							SqlSession session = sessionFactory.openSession( );
 
							StudentMapper studentmapper = session.getMapper(StudentMapper.class);
							
							Map<String,Object> studentMap = new HashMap<>();
							studentMap.put("stuAge", 18);
					studentMap.put("stuName", "zs");
					
					List<Student> studnets = studentmapper.queryStudentOrderBystuAgeOrstuNameWithHashMap(studentMap);
					
					System.out.println(studnets);
					session.close();
		}
				
		//根据地址查询学生
		public static void  queryStudentOrderByaddress() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					

//							Address address = new Address();
//							address.setHomeAddress("xiamen");
//							address.setSchoolAddress("xit");
					
					
					Student student = new Student();
					Address address = new Address();
					address.setHomeAddress("xiamen");
					address.setSchoolAddress("xit");
					
					student.setAddress(address);
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					List<Student> studnets = studentmapper.queryStudentOrderByaddress(student);
					
					System.out.println(studnets);
					session.close();
		}
		
		
		//根据存储过程查询某个年级的学生总数
		public static void  queryConutByGradeWithProcedure() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
							SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
							SqlSession session = sessionFactory.openSession( );
 
							StudentMapper studentmapper = session.getMapper(StudentMapper.class);
							//通过map给  存储过程指定输入参数
					Map<String,Object> params = new HashMap<>();
					params.put("gname", "g1");
					
					studentmapper.queryConutByGradeWithProcedure(params);//调用存储过程，并传入参数
					
					//获取存储过程的输出参数
					Object count = params.get("count");
					System.out.println(count);
					session.close();
		}
		
		//根据存储过程按学号删除学生
		public static void  deleteStudentBystunoWithProcedure() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
							SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
							SqlSession session = sessionFactory.openSession( );
 
							StudentMapper studentmapper = session.getMapper(StudentMapper.class);
							//通过map给  存储过程指定输入参数
					Map<String,Object> params = new HashMap<>();
					params.put("sno", 30);
					
					studentmapper.deleteStudentBystunoWithProcedure(params);;//调用存储过程，并传入参数
					
					//获取存储过程的输出参数
					session.commit();
					session.close();
		}
		
		
				
				
				
		//查询单个学生,结果为map类型
		public static void queryStudentOutByHashMap() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					HashMap<String, Object> studentMap = studentmapper.queryStudentOutByHashMap();//接口中的方法--->SQL语句
					
					System.out.println(studentMap);
					session.close();
		}
		
		
		//查询单个学生,结果为map类型
		public static void queryAllStudentsOutByHashMap() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					List<HashMap<String, Object>> studentMap = studentmapper.queryAllStudentsOutByHashMap();//接口中的方法--->SQL语句
					
					System.out.println(studentMap);
					session.close();
		}
				
		//============动态查询====================
		//查询单个学生,使用了sql标签
		public static void queryStuByNOrAWishSQLTag() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					Student stu = new Student();
//							stu.setStuName("zs");
					stu.setStuAge(13);
					
					Student student= studentmapper.queryStuByNOrAWishSQLTag(stu);//接口中的方法--->SQL语句
					
					System.out.println(student);
					session.close();
		}
		
		
		
				
		//将多个对象放入对象的属性中
		public static void queryStudentsWithNosInGrade() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryAllStudents";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					Grade grade = new Grade();
					List<Integer> stuNos = new ArrayList<>();
					stuNos.add(1);
					stuNos.add(2);
					grade.setStuNos(stuNos);
					List<Student> studnets = studentmapper.queryStudentsWithNosInGrade(grade);
					
					System.out.println(studnets);
					session.close();
		}
		
				
		//查询多个学生,将多个对象放入数组中   int[]
		public static void queryStudentsWithArray() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryAllStudents";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					int[] stuNos = {1,2};
					List<Student> studnets = studentmapper.queryStudentsWithArray(stuNos);
					
					System.out.println(studnets);
					session.close();
		}
				
		//查询多个学生,将多个对象放入数组中   int[]
		public static void queryStudentsWithList() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryAllStudents";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					List<Integer> stuNos = new ArrayList<>();
					stuNos.add(1);
					stuNos.add(2);
					List<Student> studnets = studentmapper.queryStudentsWithList(stuNos);
					
					System.out.println(studnets);
					session.close();
		}
				
		//查询多个学生,将多个对象放入对象数组中   
		public static void queryStudentsWithObjectArray() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryAllStudents";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					
					Student stu1 = new Student();
					stu1.setStuNo(1);
					Student stu2 = new Student();
					stu2.setStuNo(2);
					
					Student[] stus = new Student[]{stu1,stu2};
					
					List<Student> studnets = studentmapper.queryStudentsWithObjectArray(stus);
					
					System.out.println(studnets);
					session.close();
		}
				
		//查询单个学生,使用了sql标签
		public static void queryStudentByNoWithOO() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);

					
					StudentBusiness studentBusiness= studentmapper.queryStudentByNoWithOO(1);//接口中的方法--->SQL语句
					
					System.out.println(studentBusiness);
					session.close();
		}
				
		//一对一查询  ，用resultMap
		public static void queryStudentByNoWithOO2() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);

					
					Student student= studentmapper.queryStudentByNoWithOO2(2);//接口中的方法--->SQL语句
					
					System.out.println(student);
					session.close();
		}
				
		//一对多查询  ，用resultMap
		public static void queryClassAndStudents() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);

					
					StudentClass studentClass= studentmapper.queryClassAndStudents(1);//接口中的方法--->SQL语句
				
					System.out.println(studentClass.getClassId()+studentClass.getClassName());
					//班级对应的学生
					List<Student> students = studentClass.getStudents();
					for(Student student:students){
						System.out.println(student.getStuNo()+student.getStuName()+','+student.getStuAge());
					}
					
					
					session.close();
		}
		
				
				
		//查询全部学生，并延迟加载  每个学生对应的学生证
		public static void queryStudentWithOOLazyLoad() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);

					
					List<Student> students= studentmapper.queryStudentWithOOLazyLoad();//接口中的方法--->SQL语句
					for(Student student:students){
						System.out.println(student.getStuNo()+","+student.getStuName());
						StudentCard card = student.getCard();
						System.out.println(card.getCardId()+","+card.getCardInfo());
					}
					
					
					session.close();
					
		}
		
				
		//一对多查询  ，延迟加载
		public static void queryClassAndStudentsLazyload() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentClassMapper studentclassmapper = session.getMapper(StudentClassMapper.class);

					
					List<StudentClass> studentClasses= studentclassmapper.queryClassAndStudents();//接口中的方法--->SQL语句
				
					for(StudentClass stuclass:studentClasses){
						System.out.println(stuclass.getClassId()+","+stuclass.getClassName());
						System.out.println("-------------");
						for(Student student:stuclass.getStudents()){
							System.out.println(student.getStuNo()+","+student.getStuName());
						}
						
					}
					
					session.close();
				}
				
				
		//查询单个学生,验证一级缓存
		public static void queryStudentByStuno2() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession( );
					
//							String statemen = "cn.edu.xit.studentMapper.queryStudentByStuno";
					
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					Student student = studentmapper.queryStudentByStuno(1);//接口中的方法--->SQL语句
					
					session.commit();//commit会删除缓存
					
					Student student1 = studentmapper.queryStudentByStuno(1);
					System.out.println(student.getStuNo()+","+student.getStuName());
					System.out.println(student1.getStuNo()+","+student1.getStuName());
					session.close();
		}
		
				
		//查询单个学生,验证二级缓存
		public static void queryStudentByStuno3() throws IOException{
			//Connection  -   SqlSession操作MyBatis
					//conf.xml  - > reader(将一个文件变成一个对象)
					Reader reader = Resources.getResourceAsReader("conf.xml");
					//reader   - > SqlSession
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					
					//第一次查询
					SqlSession session = sessionFactory.openSession( );
					StudentMapper studentmapper = session.getMapper(StudentMapper.class);
					Student student = studentmapper.queryStudentByStuno(2);
//					session.commit();//自身commit
					session.close();//该处的close是触发将对象写入二级缓存的时机，也就是关闭一级缓存，进入二级缓存。
					
//					
//					//增删改	
//					SqlSession UpdateSession = sessionFactory.openSession( );
//					StudentMapper updatemapper = UpdateSession.getMapper(StudentMapper.class);
//					Student updatestudent = new Student();
//					updatestudent.setStuNo(2);
//					updatestudent.setStuName("lxs");
//					updatestudent.setGraName("xit");
//					
//					updatemapper.updateStudent(updatestudent);;
//					UpdateSession.commit();//清理一级和二级缓存
					
					
					//第二次查询	
					SqlSession session2 = sessionFactory.openSession( );
					StudentMapper studentmapper2 = session2.getMapper(StudentMapper.class);
					Student student2 = studentmapper2.queryStudentByStuno(2);
					
					
					
					System.out.println(student.getStuNo()+","+student.getStuName());
					System.out.println(student2.getStuNo()+","+student2.getStuName());
					session2.close();
		}
	public static void main(String[] args) throws IOException {
		//queryStudentByStuno();
	//	updateStudentByStuno();
		//deleteStudentByStuno();
		//queryAllStudents();
		//queryStudentByStunoWithConverter();
		//addStudentWithConverter();
		//addStudentWithConverter();
		//queryStudentOrderByColumn();
		//queryStudentByStuname();
		//queryStudentOrderBystuAgeOrstuName();
		//queryStudentOrderByaddress();
		//queryStudentOrderBystuAgeOrstuNameWithHashMap();
		//queryConutByGradeWithProcedure();
		//deleteStudentBystunoWithProcedure();
		//queryStudentOutByHashMap();
	//	queryAllStudentsOutByHashMap();
		//	queryStudentByAlias();
		//	queryStuByNOrAWishSQLTag();
		//queryStudentsWithNosInGrade();
		//queryStudentsWithList();
		//queryStudentsWithObjectArray();
		//	queryStudentByNoWithOO();
	//	queryStudentByNoWithOO2();
		//queryClassAndStudents();
		//queryStudentWithOOLazyLoad();
		//queryClassAndStudentsLazyload();
		queryStudentByStuno3();
	}
}
