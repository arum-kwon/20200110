package co.arum.countries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryServiceImpl extends CountryService {
	private final String ALL_SELECT = "SELECT * FROM countries";
	private final String SELECT = "SELECT * FROM countries WHERE country_id = ?";
	private final String INSERT = "INSERT INTO countries VALUES(?,?,?)";
	private final String UPDATE = "UPDATE countries SET country_name=?, region_id=? WHERE country_id=?";
	private final String DELETE = "DELETE FROM countries WHERE country_id=?";
	
	@Override
	public List<CountryDto> allSelect() {
		List<CountryDto> list = new ArrayList<CountryDto>();
		CountryDto dto;
		
		try {
			psmt = conn.prepareStatement(ALL_SELECT);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new CountryDto();
				dto.setCountry_id(rs.getString("country_id"));
				dto.setCountry_name(rs.getString("country_name"));
				dto.setRegion_id(rs.getInt("region_id"));
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CountryDto select(CountryDto dto) {
		CountryDto counDto = new CountryDto();
		
		try {
			psmt = conn.prepareStatement(SELECT);
			psmt.setString(1, dto.getCountry_id());
			rs = psmt.executeQuery();
			if(rs.next()) {
				counDto.setCountry_id(rs.getString("country_id"));
				counDto.setCountry_name(rs.getString("country_name"));
				counDto.setRegion_id(rs.getInt("region_id"));
			}else {
				System.out.println("없다");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return counDto;
	}

	@Override
	public int insert(CountryDto dto) { //"INSERT INTO countries VALUES(?,?,?)"
		
		int result =0;
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setString(1, dto.getCountry_id());
			psmt.setString(2, dto.getCountry_name());
			psmt.setInt(3, dto.getRegion_id());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(CountryDto dto) { //"UPDATE countries SET country_name=?, region_id=? WHERE country_id=?"
		int result = 0;
		try {
			psmt = conn.prepareStatement(UPDATE);
			psmt.setString(1, dto.getCountry_name());
			psmt.setInt(2, dto.getRegion_id());
			psmt.setString(3, dto.getCountry_id());
			result = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(CountryDto dto) { //"DELETE FROM countries WHERE country_id=?"
		int result =0;
		
		try {
			psmt = conn.prepareStatement(DELETE);
			psmt.setString(1, dto.getCountry_id());
			result = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
