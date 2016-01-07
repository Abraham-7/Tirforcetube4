package com.mygdx.tfg4;
//Using Mr.Grondins Drop code//

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class TGFTTube4 extends ApplicationAdapter {
	Texture txTtube,txBtube;
	SpriteBatch batch;
	Sprite sprTtube,sprBtube;
	OrthographicCamera camera;
	Array<Sprite> arsprTtube,arsprBtube;
	long movetime;
	int nspawnTime;

	@Override
	public void create () {
		txTtube = new Texture(Gdx.files.internal("toptube.png"));
		txBtube = new Texture(Gdx.files.internal("bottomtube.png"));
		nspawnTime = 1000;
		sprTtube= new Sprite(txTtube);
		sprBtube= new Sprite(txBtube);
		//Creating sprite and camera
		camera= new OrthographicCamera();
		camera.setToOrtho(false,800,480);
		batch= new SpriteBatch();
		arsprTtube= new Array<Sprite>();
		arsprBtube= new Array<Sprite>();
		spawnTtube();
		spawnBtube();

	}
	private void spawnTtube(){
		Sprite sprTtube = new Sprite(txTtube);
		sprTtube.setX(750);
		sprTtube.setY(MathUtils.random(0, 800 -100));
		arsprTtube.add(sprTtube);
		movetime= TimeUtils.nanoTime();

	}
	private void spawnBtube(){

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (Sprite sprTtube : arsprTtube) {
			batch.draw(sprTtube, sprTtube.getX(), sprTtube.getY());
		}
			batch.end();
		if(TimeUtils.nanoTime()-movetime>1000000*nspawnTime)spawnTtube();
		Iterator<Sprite> iter=arsprTtube.iterator();
		while(iter.hasNext()){
			Sprite sprTtube = iter.next();
			sprTtube.setX(sprTtube.getX()- (150)* Gdx.graphics.getDeltaTime());

		}
		}
}
