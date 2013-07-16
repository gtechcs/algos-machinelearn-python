package cis256.proj6;


class PriQOverflowException extends RuntimeException
{
  public PriQOverflowException()
  {
  }

  public PriQOverflowException(String message)
  {
    super(message);
  }
}