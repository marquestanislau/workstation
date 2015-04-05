package mz.com.dao.testes;



public class TestsDAO {

//	@Test
//	public void dbTest() {
//		UserDAO dao = new UserDAO();
//		dao.beginTransaction();
//		User user = new User();
//		user.setDateRegistered(Calendar.getInstance());
//		user.setEmail("konvict@konvictmuzikinc.com");
//		user.setName("lalau");
//		user.setPassword("konvict");
//		user.setPermission(Permission.ADMIN);
//		
//		dao.save(user);
//		dao.commitAndCloseTransaction();
//		System.out.println("Salvou com sucesso!");
//	}
//	
//	@Test
//	public void dbTestP() {
//		Product p = new Product();
//		p.setBuyPrice(200.00);
//		p.setDateRegistered(Calendar.getInstance());
//		p.setName("Toyota Alteza");
//		p.setQuantity(1);
//		p.setSellPrice(500.00);
//		
//		ProductDAO dao = new ProductDAO();
//		dao.beginTransaction();
//		dao.save(p);
//		dao.commitAndCloseTransaction();
//	}
//	
//	@Test
//	public void dbTestS() {
//		Supplier s = new Supplier();
//		s.setName("Open Soft");
//		s.setAddress("av. kill il sung");
//		s.setDateRegistered(Calendar.getInstance());
//		s.setEmail("soft@open12.com");
//		
//		List<Product> pr = new ArrayList<Product>();
//		
//		Product p = new Product();
//		p.setBuyPrice(200.00);
//		p.setDateRegistered(Calendar.getInstance());
//		p.setName("Toyota Alteza");
//		p.setQuantity(1);
//		p.setSellPrice(500.00);
//		pr.add(p);
//		
//		ProductDAO dp = new ProductDAO();
//		dp.beginTransaction();
//		dp.save(p);
//
//		
//		s.setProducts(pr);
//		SupplierDAO dao = new SupplierDAO();
//		dao.beginTransaction();
//		dao.save(s);
//		dao.commitAndCloseTransaction();
//		dp.commitAndCloseTransaction();
//	}
//	@Test
//	public void findAllTest() {
//		ProductDAO dao = new ProductDAO();
//		JTextArea area = new JTextArea();
//		for(Product p : dao.findAll()) {
//			area.append(p.getName() + "\n");
//		}
//		JOptionPane.showMessageDialog(null, area);
//	}
//	
//	@Test
//	public void testFindUserByName() {
//		UserDAO dao = new UserDAO();
//		User user = dao.findByName("lalau");
//		
//		if(user != null)
//			System.out.println(user.getName());
//		else 
//			System.out.println("User not found!");
//		
//		dao.commitAndCloseTransaction();
//	}
//	
//	@Test
//	public void compareDates() {
//		ProductDAO dao = new ProductDAO();
//		for(Product p: dao.findAll()) {
//			if(p.getDateRegistered().compareTo(Calendar.getInstance()) == 0)
//				System.out.println("iguais");
//			else 
//				System.out.println("diferentes");
//		}
//	}
//	@Test
//	public void insert() {
//		Compra c = new Compra();
//		c.setDate(Calendar.getInstance());
//		c.setName("lalau");
//		c.setQtd(20);
//		
//		CompraDAO d = new CompraDAO();
//		d.save(c);
//		d.commitAndCloseTransaction();
//	}
	
}
