package ca.pfv.spmf.algorithms.clustering.kmeans;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import ca.pfv.spmf.algorithms.clustering.distanceFunctions.DistanceEuclidian;
import ca.pfv.spmf.algorithms.clustering.distanceFunctions.DistanceFunction;
import ca.pfv.spmf.algorithms.clustering.kmeans.AlgoKMeans;
import ca.pfv.spmf.patterns.cluster.ClusterWithMean;
import ca.pfv.spmf.patterns.cluster.DoubleArray;

/**
 *  Example of how to use the KMEans algorithm, in source code.
 */
public class MainTestKMeans_saveToMemory {
	
	public static void main(String []args) throws NumberFormatException, IOException{
		
		String input = fileToPath("inputDBScan2.txt");
		// Cantidad de Clusters "K"
		int k=3;	
		
		// Especificación del separador de las lineas. Si los conjuntos de datos estan separados por "," ";" " ".. Etc.
		String separator = " ";
		
		// Especificar algoritmo para calcular la distancia. En este caso es la distancia Euclidiana
		DistanceFunction distanceFunction = new DistanceEuclidian(); 
		
		// Llamando al metodo que contiene el algoritmo
		AlgoKMeans algoKMeans = new AlgoKMeans();  
		List<ClusterWithMean> clusters = algoKMeans.runAlgorithm(input, k, distanceFunction, separator);
		algoKMeans.printStatistics();
		
		// Print the clusters found by the algorithm
		// For each cluster:
		int i=0;
		for(ClusterWithMean cluster : clusters) {
			System.out.println("Cluster " + i++);
			// For each data point:
			for(DoubleArray dataPoint : cluster.getVectors()) {
				System.out.println("   " + dataPoint);
			}
		}
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestKMeans_saveToMemory.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
	
	
}
