package sample;

import java.sql.*;

public class JdbcSampleMain {

	public static void main(String[] args) {
		try {
			// �P�DJDBC Driver �̓o�^
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// �Q�D�f�[�^�x�[�X�ւ̐ڑ�
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tdrw", "root", "tdr4root");

			// �R�DSQL �X�e�[�g�����g�E�I�u�W�F�N�g�̍쐬
			Statement stmt = con.createStatement();
			// �S�DSQL �X�e�[�g�����g�̔��s
			ResultSet rs = stmt.executeQuery("SELECT * from sample");
			// �T�D���ʂ̏o��
			while (rs.next()) {
				System.out.println(rs.getString("text"));
			}

			// �U�D�f�[�^�x�[�X�̃N���[�Y
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
