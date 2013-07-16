package cis256.proj6;


class PriQUnderflowException extends RuntimeException
{
  public PriQUnderflowException()
  {
  }

  public PriQUnderflowException(String message)
  {
    super(message);
  }
}