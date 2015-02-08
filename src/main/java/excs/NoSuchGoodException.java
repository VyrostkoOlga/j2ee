package excs;

public class NoSuchGoodException extends Exception
{
	String _message;
	
	public NoSuchGoodException(String goodName)
	{
		_message = String.format("There is no good with name %s in the warehouse", goodName);
	}
	
	public String getMessage()
	{
		return _message;
	}

}
