from fastapi import FastAPI, HTTPException
from models.club import Club
from models.competition import Competition
from data.clubs import CLUBS
from data.competitions import COMPETITIONS
from fastapi.middleware.cors import CORSMiddleware


app = FastAPI()


@app.get("/")
def read_root():
    return {"message": "Welcome to the Treble Continental Winner Football Club API!"}

@app.get("/clubs", response_model=list[Club])
def get_all_clubs():
    return CLUBS

@app.get("/clubs/{club_id}", response_model=Club)
def get_club(club_id: str):
    for club in CLUBS:
        if club.id == club_id:
            return club
    raise HTTPException(status_code=404, detail="Club not found")

@app.get("/competitions", response_model=list[Competition])
def get_all_competitions():
    return COMPETITIONS

@app.get("/competitions/{competition_id}", response_model=Competition)
def get_competition(competiton_id: str):
    for comp in COMPETITIONS:
        if comp.id == competiton_id:
            return comp
    raise HTTPException(status_code=404, detail="Competition not found")


app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://10.16.72.89:8000"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)