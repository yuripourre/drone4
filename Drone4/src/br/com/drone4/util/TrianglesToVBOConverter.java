package br.com.drone4.util;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import jdt.triangulation.Triangle;
import br.com.abby.adapter.PointToVectorAdapter;
import br.com.abby.vbo.Face;
import br.com.abby.vbo.VBO;
import br.com.etyllica.linear.Point3D;

public class TrianglesToVBOConverter {

	public static VBO convert(List<Triangle> triangles) {
		
		VBO vbo = new VBO();
		
		int i = 1;
		for(Triangle triangle: triangles) {
			vbo.getVertices().add(adapt(triangle.getA()));
			vbo.getVertices().add(adapt(triangle.getB()));
			vbo.getVertices().add(adapt(triangle.getC()));
			vbo.getNormals().add(calculateNormal(triangle));
			
			int normalIndex = (int)(i/2);
			
			vbo.getFaces().add(new Face(3)
					.addVertexes(i, i+1, i+2)
					.addNormals(normalIndex,normalIndex,normalIndex));
			
			System.out.println("Add normal: "+(int)(i/2));
			
			i+=3;
		}
		
		return vbo;
	}
	
	/**
	 * Based on https://www.opengl.org/wiki/Calculating_a_Surface_Normal
	 * @param triangle
	 * @return
	 */
	private static Vector3f calculateNormal(Triangle triangle) {
		
		Point3D u = triangle.getB().sub(triangle.getA());
		Point3D v = triangle.getC().sub(triangle.getA());
		
		float nx = (float)(u.getY()*v.getZ() - u.getZ()*v.getY());
		float ny = (float)(u.getZ()*v.getX() - u.getX()*v.getZ());
		float nz = (float)(u.getX()*v.getY() - u.getY()*v.getX());
		
		Vector3f normal = new Vector3f(nx, ny, nz);
		return normal;
	}
	
	public static VBO convert(List<Triangle> triangles, Point3D origin) {
		
		VBO vbo = new VBO();
		
		int i = 1;
		for(Triangle triangle: triangles) {
			vbo.getVertices().add(adapt(movePoint(origin, triangle.getA())));
			vbo.getVertices().add(adapt(movePoint(origin, triangle.getB())));
			vbo.getVertices().add(adapt(movePoint(origin, triangle.getC())));
			vbo.getNormals().add(calculateNormal(triangle));
			
			int normalIndex = (int)(1+i/3);
			
			vbo.getFaces().add(new Face(3)
					.addVertexes(i, i+1, i+2)
					.addNormals(normalIndex,normalIndex,normalIndex));
			i+=3;
		}
		
		return vbo;
	}
	
	private static Vector3f adapt(Point3D point) {
		return PointToVectorAdapter.adapt(point);
	}
	
	private static Point3D movePoint(Point3D origin, Point3D point) {
		double px = point.getX()-origin.getX();
		double py = point.getY()-origin.getY();
		double pz = point.getZ()-origin.getZ();
		
		return new Point3D(px, py, pz);
	}
	
}
