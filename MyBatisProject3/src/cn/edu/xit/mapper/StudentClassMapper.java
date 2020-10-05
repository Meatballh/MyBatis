package cn.edu.xit.mapper;

import java.util.List;

import cn.edu.xit.entity.StudentClass;

public interface StudentClassMapper {
	//查询全部班级
	List<StudentClass> queryClassAndStudents();
}
