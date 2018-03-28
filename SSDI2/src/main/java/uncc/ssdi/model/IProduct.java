package uncc.ssdi.model;

public interface IProduct {
	public Long getId();
	public void setId(Long id);
	public String getName();
	public void setName(String name);
	public String getDescription();
	public float getBasePrice();
}
