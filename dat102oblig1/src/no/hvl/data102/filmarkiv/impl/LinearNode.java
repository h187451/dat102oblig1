package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {
	
	public T data;
	public LinearNode<T> neste;
	
	public LinearNode(T data) {
		this.data = data;
		this.neste = null;
	}
	
	public T getData()  {
		return this.data;
	}
	
	public LinearNode<T> getNeste()  {
		return this.neste;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNeste(LinearNode<T> neste) {
		this.neste = neste;
	}
}
