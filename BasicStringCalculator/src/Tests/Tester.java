package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import BSC.GuiCalc;


public class Tester{
	
	private static final double RANGE= 0.0001;
	private GuiCalc calc;
	
	
	@Before
	public void beforeTests() {
		calc = new GuiCalc();
	}
	
	
	@Test
	public void test() {
		String equation = "3+4*5-6";
		double expect = 17;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	
	@Test
	public void test2() {
		String equation = "3+4*5/4-3";
		double expect = 5.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	@Test
	public void test3() {
		String equation = "5%3/33";
		double expect = 0.0909;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	@Test
	public void test4() {
		String equation = "33/5%3";
		double expect = 0.599999;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	@Test
	public void test5() {
		String equation = "33/5%3+5";
		double expect = 5.599999;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	@Test
	public void test6() {
		String equation = "33/5%3*10";
		double expect = 5.999999;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	@Test
	public void test7() {
		String equation = "10*33/5%3";
		double expect = 5.999999;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	@Test
	public void test8() {
		String equation = "5%3*33/2";
		double expect = 33.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	@Test
	public void test9() {
		String equation = "5%3*33";
		double expect = 66.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
		
	@Test
	public void whenStringOneGetDoubleOne() {
		
		String equation = "1";
		double expect = 1.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	

	@Test
	public void whenStringTowGetDoubleTwo() {
		
		String equation= "2";
		double expect = 2.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	@Test
	public void whenStringOnePlusOneGetDoubleTwo() {
		
		String equation = "1+1";
		double expect = 2.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	@Test
	public void whenStringOnePlusOnePlusOneGetDoubleThree() {
		
		String equation = "1+1+1";
		double expect = 3.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	@Test
	public void whenStringTwoTimesTowGetDoubleFour() {
		
		String equation = "2*2";
		double expect = 4.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	@Test
	public void whenStringTwoMinusOneGetDoubleOne() {
		
		String equation = "2-1";
		double expect = 1.0;
		
		double actual =  calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);		
	}
	
	@Test
	public void whenStringNineDivideByThreeGetDobuleThree() {
		
		String equation ="9/3";
		double expect = 3.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}
	
	
	@Test
	public void modulusCalc() {
		String equation = "9%5";
		double expect = 4.0;
		
		double actual = calc.Calculate(equation);
		
		assertEquals(expect, actual, RANGE);
	}

}
