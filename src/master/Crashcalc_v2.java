package master;

import java.text.DecimalFormat;

public class Crashcalc_v2
{
	
	public static double multiInBracket(double chart[], double min, double max)
	{
		
		double count = 0;
		
		for(int i = 0; i < chart.length; i++)
		{
			
			if(chart[i] >= min && chart[i] <= max)
			{
				count++;
				
			}
		}
		
		return count;
	}
	
	
	
	public static double cumulativeBracket(double chart[], double min)
	{
		double count = 0;
		
		for(int i = 0; i < chart.length; i++)
		{
			
			if(chart[i] >= min)
			{
				count++;
			}
		}
		
		return count;
	}
	
	
	
	public static void displayPerBrac(double chart[], double v1, double v2)
	{
		DecimalFormat df = new DecimalFormat("#.##");
		
		int totalNumbers = chart.length;
		
		double riskbracket = multiInBracket(chart, v1, v2);
		double risk = (riskbracket/totalNumbers)*100;
		
		if(v1 == 1.00 && v2 == 1.04)
		{
			System.out.println("Instaloss rate between " + v1 + " to " + " to " + v2 + " is:  " + df.format(risk) + "%");
		}
		else
		{
			System.out.println("Chance to hit between " + v1 + " to " + v2 + " is:      " + df.format(risk) + "%");
		}
	}
	
	
	public static void displayCumul(double chart[], double v1)
	{
		DecimalFormat df = new DecimalFormat("#");
		DecimalFormat df2 = new DecimalFormat("#.##");
		
		int totalNumbers = chart.length;
		
		double cumul = cumulativeBracket(chart, v1);
		double riskcumul = (cumul/totalNumbers)*100;
		
		double betCalc = (v1 - 1);
		double amountBets = 1/betCalc;
		
		System.out.println("Chance to hit " + v1 + " or over: " + df2.format(riskcumul) + "%, to make back need " + df.format(Math.ceil(amountBets)) + 
				" bets(" + df.format((Math.pow(riskcumul, amountBets))/Math.pow(100, amountBets)*100) + "% chance) or x" + df2.format(amountBets) + " stake" );
	}
	
	
	public static void quickcalc(double chart[])
	{
		double sum = 0;
		
		for(int i = 0; i < chart.length; i++)
		{
			sum = sum + chart[i];
		}
		
		System.out.println("Total sum is: " + sum);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[])
	{
		
		double[] multiplier =
			{
					2.04, 1.00, 1.35, 1.02, 1.22, 3.13, 4.85, 60.28, 1.29, 1.56, 1.25, 1.69, 1.57, 65.17, 1.03, 2.52, 1.07, 1.12, 6.59, 1.74, 3.59, 1.18, 3.42, 2.50, 204.26, 1.08, 7.40, 1.03, 2.28, 3.41, 1.24, 2.46, 2.27,
					2.49, 1.00, 3.07, 2.30, 65.86, 1.45, 1.35, 1.65, 1.67, 12.72, 1.02, 1.26, 1.91, 2.49, 1.24, 1.21, 3.32, 1.30, 1.46, 5.28, 1.83, 2.78, 1.04, 3.16, 2.36, 1.34, 1.18, 7.90, 1.51, 1.09, 4.25, 7.02, 2.57, 3.05,
					2.26, 2.60, 34.62, 2.90, 5.38, 2.48, 3.74, 1.24, 1.48, 3.15, 1.00, 3.26, 1.72, 1.00, 1.24, 3.11, 1.43, 1.52, 3.80, 16.98, 4.70, 1.53, 4.56, 3,60, 1.41, 1.30, 1.60, 1.72, 1.63, 2.85, 23.53, 1018.97, 2.66,
					1.91, 1.16, 2.52, 1.70, 1.64, 1.16, 1.29, 1.92, 1.94, 1.18, 1.15, 1.29, 1.47, 1.58, 2.00, 1.17, 4.39, 1.23, 1.17, 1.83, 9.81, 1.74, 9.92, 2.72, 3.27, 2.50, 1.14, 13.16, 1.07, 1.36, 72.19, 4.64, 1.08, 2.97,
					1.28, 1.07, 4.68, 22.82, 1.00, 5.75, 1.47, 1.00, 40.50, 1.74, 16.69, 6.17, 1.46, 3.57, 3.10, 1.03, 3.49, 3.35, 4.19, 2.43, 1.24, 48.29, 1.02, 11.67, 2.08, 1.47, 2.19, 1.27, 1.74, 1.00, 1.75, 1.64, 2.47,
					43.38, 82.10, 1.35, 18.65, 3.30, 1.06, 1.84, 1.91, 2.61, 1.87, 1.64, 1.77, 1.36, 1.86, 1.04, 1.37, 2.31, 5.34, 1.15, 1.07, 4.90, 1.10, 1.70, 2.96, 53.38, 1.81, 1.43, 2.15, 25.11, 1.59, 1.50, 1.07, 1.33,
					1.37, 1.00, 1.78, 1.06, 1.04, 3.04, 1.21, 1.29, 2.60, 2.57, 26.29, 6.80, 2.59, 1.18, 4.81, 8.70, 1.85, 1.31, 1.35, 20.05, 16.32, 1.03, 68.09, 1.76, 2.00, 1.56, 9.12, 2.84, 2.85, 2.29, 7.01, 1.34, 2.93,
					22.50, 1.07, 2.34, 1.03, 67.77, 9.82, 2.72, 4.97, 2.14, 1.29, 6.83, 2.63, 1.08, 1.78, 1.65, 1.00, 8.77, 11.72, 2.22, 1.55, 1.50, 1.06, 7.32, 21.96, 10.98, 1.31, 1.37, 1.73, 12.30, 1.51, 2.07, 5.87, 1.27,
					8.22, 1.30, 2.60, 6.05, 2.98, 2.13, 1.60, 1.25, 1.66, 2.23, 1.22, 1.12, 2.88, 1.36, 4.55, 1.00, 1.04, 3.05, 1.49, 2.92, 1.82, 1.34, 1.60, 4.44, 1.10, 6.03, 3.44, 4.06, 1.08, 2.37, 8.96, 6.12, 1.07, 2.19,
					1.11, 7.67, 3.42, 1.43, 1.66, 1.88, 8.13, 1.00, 1.42, 1.22, 29.74, 1.73, 1.63, 1.33, 10.87, 4.91, 8.90, 1.50, 13.25, 1.73, 1.38, 2.06, 1.31, 2.18, 1.09, 5.57, 7.68, 1.00, 10.88, 1.31, 1.59, 2.56, 1.05,
					4.70, 2.29, 1.65, 1.55, 1.66, 2.34, 1.00, 1.08, 1.27, 1.00, 2.67, 1.04, 1.18, 1.03, 1.58, 1.87, 1.20, 4.49, 1.23, 2.90, 2.15, 1.34, 1016.28, 1.82, 5.39, 55.21, 6.72, 1.29, 1.71, 70.68, 1.67, 27.46, 1.42,
					2.13, 2.92, 1.00, 1.08, 5.06, 1.07, 2.07, 1.06, 1.36, 1.02, 1.04, 1.82, 6.44, 1.31, 1.86, 1.33, 1.50, 4.25, 1.79, 34.20, 29.47, 1.63, 2.11, 1.07, 6.54, 4.86, 1.29, 3.54, 2.64, 2.76, 2.74, 1.03, 4.21, 
					1.03, 1.20, 1.26, 1.00, 2.97, 1.50, 2.95, 4.35, 1.69, 1.50, 1.51, .188, 1.67, 1.90, 1.07, 4.65, 2.00, 1.20, 3.50, 1.10, 2.05, 1.14, 2.18, 1.27, 60.40, 4.16, 4.48, 1.30, 1.00, 1.88, 1.12, 1.14, 1.10, 12.13,
					1.36, 2.69, 2.09, 1.58, 1.19, 2.54, 5.05, 2.51, 5.08, 1.06, 2.46, 1.43, 1.84, 2.24, 1.02, 1.39, 3.07, 1.21, 3.82, 1.92, 76.57, 2.83, 1.00, 2.53, 1.81, 6.78, 3.63, 1.06, 2.45, 1.85, 1.76, 1.08, 11.17, 2.98, 
					2.66, 5.97, 1.34, 3.37, 1.80, 1.20, 2.77, 1.03, 1.00, 1.19, 22.48, 12.47, 6.72, 2.34, 106.41, 1.70, 12.40, 2.93, 37.74, 1.63, 1.00, 1.32, 1.50, 693.92, 1.19, 1.32, 1.00, 6.02, 1.86, 38.91, 1.03, 1.14, 1.42,
					1.09, 1.81, 1.07, 1.39, 1.87, 1.11, 1.07, 1.39, 1.87, 1.11, 1.07, 6.67, 2.71, 1.97, 33.21, 2.57, 34.38, 6.84, 7.68, 1.34, 3.29, 1.22, 1.85, 1.00, 1.00, 1.32, 10.26, 1.18, 3.50, 1.80, 10.42, 1.67, 1.17, 1.56,
					1.26, 1.81, 2.82, 1.63, 14.65, 1.84, 3.97, 1.48, 1.00, 2.79, 7.91, 64.13, 1.03, 2.09, 5.59, 1.24, 1.51, 4.45, 18.08, 2.69, 1.64, 6.87, 1.85, 2.27, 2.91, 1.54, 1.77, 1.64, 3.69, 2.09, 1.00, 1.70, 1.35, 2.50,
					7.18, 1.10, 4.45, 1.85, 1.24, 2.45, 1.67, 1.00, 2.35, 2.10, 50.75, 1.39, 12.21, 7.40, 1.17, 1.81, 2.30, 7.89, 1.11, 1.51, 1.86, 2.14, 2.42, 1.90, 2.02, 3.39, 1.27, 1.48, 1.53, 2.64, 1.02, 1.46, 3.06, 1.21,
					1.42, 1.14, 4.24, 2.28, 1.45, 4.24, 2.28, 1.45, 14.31, 4.65, 2.14, 1.65, 48.28, 1.56, 1.01, 1.40, 81.07, 1.54, 1.27, 1.29, 1.97, 1.89, 1.18, 1.29, 1.35, 1.23, 27.99, 1.26, 2.69, 18.90, 2.21, 1.09, 463.51, 2.55,
					2.92, 58.89, 1.18, 1.25, 4.43, 1.52, 5.11, 1.62, 1.00, 3.40, 4.10, 2.32, 2.12, 2.45, 1.35, 3.53, 1.37, 34.70, 5.93, 1.21, 5.33, 2.39, 2.77, 1.26, 46.48, 1.00, 1.30, 1.03, 2.67, 17.18, 1.93, 1.00, 3.88, 2.64, 
					1.34, 8.84, 1.47, 6.40, 1.77, 1.55, 1.21, 2.76, 278.03, 1.27, 1.99, 1.63, 1.98, 1.14, 1.36, 2.18, 337.17, 2.42, 1.11, 1.00, 1.00, 1.70, 4.07, 1.35, 2.09, 3.63, 1.88, 1.43, 2.38, 1.00, 3.46, 1.26, 1.32, 1.13,
					1.65, 1.32, 1.24, 6.58, 20.24, 1.29, 32.94, 1.58, 3.85, 1.03, 1.19, 1.09, 1.35, 2.25, 1.90, 2.65, 6.72, 2.93, 4.02, 2.28, 4.26, 5.37, 2.06, 1.26, 6.74, 1.34, 1.00, 1.29, 1.11, 1.03, 2.20, 1.14, 4.90, 1.55,
					2.39, 3.23, 1.97, 1829, 1.09, 3.14, 1.09, 1.48, 1.36, 3.01, 5.20, 1.16, 11.12, 1.23, 1.58, 5.73, 1.00, 13.16, 3.22, 7.71, 3.84, 4.42, 2.71, 8.42, 1.64, 1.65, 2.94, 3.12, 6.49, 2.80, 1.45, 2.28, 4.28, 4.13,
					1.05, 6.44, 1.04, 1.46, 8.22, 6.11, 2.86, 2.78, 2.37, 2.60, 1.61, 2.93, 31.75, 2.17, 1.08, 1.92, 1.04, 1.03, 6.27, 1.29, 1.62, 96.38, 1.08, 1.46, 1.00, 1.13, 1.36, 2.14, 2.62, 1.08, 1.37, 3.58, 1.79, 11.04,
					1.50, 1.30, 1.10, 5.57, 1.25, 1.15, 10.50, 1.00, 6.53, 2.49, 1.18, 4.05, 1.27, 1.42, 3.84, 1.04, 6.20, 25.83, 1.00, 1.47, 1.36, 1.22, 1.10, 1.12, 83.03, 99.07, 1.37, 2.46, 1.35, 1.25, 1.83, 3.11, 1.09, 2.18,
					1.67, 5.52, 1.48, 1.78, 2.98, 108.38, 2.90, 6.89, 1.82, 1.69, 1.30, 1.71, 3.45, 1.26, 1.58, 1.57, 14.16, 1.74, 9.11, 11.11, 1.45, 2.12, 1.04, 8.90, 2.79, 10.32, 3.01, 2.01, 13.34, 1.38, 4.99, 2.14, 1.99, 
					1.66, 24.53, 2.44, 1.01, 3.25, 3.02, 5.05, 1.66, 6.10, 1.78, 1.00, 1.01, 1.10, 1.66, 2.18, 2.08, 1.57, 4.03, 6.74, 1.09, 1.99, 1.76, 2.95, 192.39, 1.40, 1.68, 1.21, 1.02, 1.10, 1.10, 1.10, 1.15, 1.39, 3.84,
					1.56, 1.19, 2.51, 1.85, 1.23, 20.46, 1.30, 1.79, 1.00, 1.00, 6.62, 3.44, 4.32, 3.20, 1.65, 8.45, 45.71, 2.24, 1.34, 1.66, 1.22, 3.41, 1.96, 1.06, 6.33, 16.28, 1.09, 1.27, 15.97, 13.78, 145.31, 1.10, 1,00, 2.89,
					1.37, 1.82, 1.12, 3.99, 1.11, 1.85, 19.51, 1.02, 2.58, 2.72, 1.35, 1.94, 3.48, 1.38, 2.18, 1.62, 1.28, 1.56, 1.24, 1.03, 1.40, 1.61, 3.05, 1.72, 1.68, 1.89, 1.80, 1.00, 1.74, 2.20, 1.75, 1.63, 2.92, 1.06, 1.00,
					1.09, 1.33, 1.05, 1.00, 1.19, 1.39, 40.45, 1.36, 1.46, 8.84, 5.44, 2.98, 2.02, 1.30, 1.65, 16.34, 1.21, 1.26, 2.00, 10.06, 10.31, 2.60, 1.38, 3.04, 2.02, 5.21, 1.65, 5.63, 4.71, 3.88, 1.22, 7.62, 2.10, 1.67, 
					1.72, 5.74, 18.39, 1.46, 1.18, 1.34, 5.10, 1.24, 1.21, 1.02, 4.08, 7.07, 1.70, 1.09, 2.49, 9.82, 1.04, 18.67, 20.00, 1.45, 1.01, 9.39, 1.83, 3.49, 1.21, 2.34, 1.44, 30.32, 2.56, 1.48, 1.72, 3.27, 1.28, 3.46, 4.19,
					11.86, 2.12, 20.40, 9.68, 1.15, 2.13, 1.09, 2.52, 3.47, 1.14, 1.10, 1.15, 3.42, 1.27, 1.68, 1.24, 23.08, 2.66, 17.08, 3.65, 1.51, 1.23, 1.52, 10.82, 16.99, 23.93, 2.76, 2.00, 2.11, 9.91, 1.56, 1.04, 1.12, 2.50,
					2.41, 1.18, 2.56, 5.36, 1.71, 1.20, 3.61, 1.50, 78.58, 1.95, 1.37, 1.43, 1.50, 5.06, 1.12, 1.16, 1.36, 1.09, 1.24, 1.30, 4.38, 77.45, 2.24, 2.52, 17.47, 1.38, 1.06, 5.15, 22.15, 1.16, 1.00, 1.10, 1.35, 7.14,
					1.26, 1.06, 3.55, 1.31, 1.61, 1.63, 1.34, 7.53, 7.21, 3.51, 4.15, 2.73, 1.73, 9.12, 1.65, 1.52, 1.00, 1.07, 1.34, 1.31, 15.18, 1.33, 1.85, 6.71, 3.30, 1.02, 65.07, 14.37, 3.12, 17.54, 1.15, 1.00, 1.02, 1.59, 1.31,
					1.36, 10.84, 1.00, 2.77, 3.32, 1.09, 1.13, 2.00, 1.00, 7.03, 22.05, 2.86, 1.91, 3.50, 8.08, 1.49, 1.11, 1.66, 1.70, 6.07, 1.29, 1.00, 1.97, 1.92, 2.13, 17.30, 2.45, 2.33, 1.41, 2.18, 1.81, 11.16, 1.08, 1.13, 1.35,
					2.24, 2.28, 10.46, 1.00, 5.61, 2.90, 6.70, 1.13, 26.28, 1.90, 7.61, 1.00, 2.86, 4.69, 1.18, 5.94, 1.28, 1.59, 94.15, 5.55, 1.00, 213.57, 1.68, 1.00, 4.80, 10.88, 1.89, 1.64, 1.00, 1.32, 1.07, 2.54, 1.60, 3.62, 1.80,
					1.10, 6.65, 1.51, 1.70, 25.03, 1.05, 1.04, 2.03, 3.61, 2.15, 4.36, 1.40, 1.08, 197.21, 5.14, 1.71, 1.40, 10.52, 1.68, 5.12, 2.94, 3.35, 1.00, 1.47, 1.04, 3.29, 1.03, 2.13, 1.24, 1.00, 5.49, 4.28, 1.10, 2.17,
					1.25, 2.01, 1.09, 1.47, 2.80, 1.21, 1.90, 65.33, 1.10, 1.46, 1.91, 1.12, 1.14, 11.08, 1.05, 2.77, 2.09, 5.29, 5.23, 1.51, 1.01, 3.32, 4.92, 2.42, 1.18, 1.64, 1.67, 1.29, 3.14, 22.21, 30.94, 1.53, 1.38, 1.47,
					192.18, 3.96, 1.11, 2.36, 1.24, 5.90, 5.53, 1.07, 1.20, 1.99, 1.70, 8.07, 2.04, 1.42, 1.05, 1.56, 85.09, 1.70, 16.57, 1.29, 1.25, 2.03, 10.64, 1.22, 1.10, 2.94, 1.66, 3.01, 2.20, 1.16, 3.70, 1.73, 1.84, 13.94,
					5.02, 1.13, 8.87, 8.20, 4.56, 2.51, 1.36, 1.91, 1.46, 2.35, 3.88, 5.60, 1.39, 2.92, 1.03, 56.72, 57.67, 1.33, 3.69, 14.76, 1.11, 31.67, 1.00, 1.40, 4.35, 2.81, 21.27, 1.85, 1.00, 1.77, 1.55, 1.24, 1.91, 4.67, 
					2.70, 1.00, 3.43, 1.33, 16.40, 1.54, 2.24, 1.52, 4.98, 4.27, 1.84, 1.30, 3.76, 3.40, 1.00, 7.68, 1.00, 1.82, 1.67, 1.66, 9.29, 4.04, 4.81, 9.08, 9.67, 10.36, 1.01, 1.36, 1.35, 2.01, 1.54, 3.52, 7.53, 2.10, 1.06,
					1.15, 1.04, 1.84, 1.03, 1.13, 7.76, 2.80, 1.19, 5.73, 1.19, 3.89, 2.85, 1.16, 3.11, 1.61, 4.97, 1.22, 29.64, 1.32, 1.19, 3.78, 1.33, 9.70, 1.19, 1.41, 1.67, 18.42, 1.13, 3.36, 5.89, 1.23, 7.38, 75.20, 2.68, 1.17,
					1.38, 1.00, 1.32, 4.80, 1.45, 1.16, 1.00, 6.18, 2.11
					
					
					
					
					
			};
		/*
		double[] quickcalc = {0.003, 0.0075, 0.01875, 0.046875, 0.1171875, 0.29296875, 0.732421875, 1.8310546875, 4.57763671875,
				11.444091796875, 28.6102294921875, 71.52557373046875
				
		};*/
		
		displayPerBrac(multiplier, 1.00, 1.04);
		displayPerBrac(multiplier, 1.05, 1.15);
		displayPerBrac(multiplier, 1.16, 1.25);
		displayPerBrac(multiplier, 1.26, 1.35);
		displayPerBrac(multiplier, 1.36, 1.45);
		displayPerBrac(multiplier, 1.46, 1.55);
		displayPerBrac(multiplier, 1.56, 1.65);
		displayPerBrac(multiplier, 1.66, 1.75);
		displayPerBrac(multiplier, 1.76, 1.85);
		displayPerBrac(multiplier, 1.86, 1.95);
		displayPerBrac(multiplier, 1.96, 2.05);
		displayPerBrac(multiplier, 2.06, 2.15);
		displayPerBrac(multiplier, 2.16, 2.25);
		displayPerBrac(multiplier, 2.26, 2.35);
		displayPerBrac(multiplier, 2.36, 2.45);
		displayPerBrac(multiplier, 2.46, 2.55);
		displayPerBrac(multiplier, 2.56, 2.65);
		displayPerBrac(multiplier, 2.66, 2.75);
		
		System.out.println(" ");
		
		displayCumul(multiplier, 1.01);
		displayCumul(multiplier, 1.05);
		displayCumul(multiplier, 1.10);
		displayCumul(multiplier, 1.15);
		displayCumul(multiplier, 1.20);
		displayCumul(multiplier, 1.25);
		displayCumul(multiplier, 1.30);
		displayCumul(multiplier, 1.35);
		displayCumul(multiplier, 1.40);
		displayCumul(multiplier, 1.50);
		displayCumul(multiplier, 1.60);
		displayCumul(multiplier, 1.70);
		displayCumul(multiplier, 1.80);
		displayCumul(multiplier, 2.00);
		
		System.out.println(" ");
		System.out.printf("There is " + multiplier.length);
		
		/*quickcalc(quickcalc);*/
		
		
	}
}






