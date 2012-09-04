package sample;

import java.sql.*;

public class JdbcSampleMain {

	public static void main(String[] args) {
		try {
			// １．JDBC Driver の登録
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// ２．データベースへの接続
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tdrw", "root", "tdr4root");

			// ３．SQL ステートメント・オブジェクトの作成
			Statement stmt = con.createStatement();
			// ４．SQL ステートメントの発行
			ResultSet rs = stmt.executeQuery("SELECT * from sample");
			// ５．結果の出力
			while (rs.next()) {
				System.out.println(rs.getString("text"));
			}

			// ６．データベースのクローズ
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e1) {
			System.out.println("SQLException: " + e1.getMessage());
			System.out.println("    SQLState: " + e1.getSQLState());
			System.out.println(" VendorError: " + e1.getErrorCode());
		} catch (Exception e2) {
			System.out.println("Exception: " + e2.getMessage());
		}
	}
}
