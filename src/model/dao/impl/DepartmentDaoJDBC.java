package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        
    }

    @Override
    public void update(Department obj) {
        
    }

    @Override
    public void deleteById(Integer id) {
        
        
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
            "SELECT department.* "            
            +"FROM department "
            +"WHERE department.Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();
            
            if(rs.next()){
          
                Map<Integer, Department> map = new HashMap<>();
                Department dep = map.get(rs.getInt("Id"));

                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("Id"), dep);
                }
                return dep;
            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        
        return null;
    }
}